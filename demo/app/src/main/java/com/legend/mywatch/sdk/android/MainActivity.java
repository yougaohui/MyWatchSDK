package com.legend.mywatch.sdk.android;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.legend.mywatch.sdk.android.base.adapter.BaseActivity;
import com.legend.mywatch.sdk.android.scan.ScanActivity;
import com.legend.mywatch.sdk.mywatchsdklib.android.constant.PermissionConstants;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.AckEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.ConnectStatusEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.sdk.SDKCmdManager;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.ActivityUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.BleUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.PermissionUtils;

@SuppressLint("MissingInflatedId")
public class MainActivity extends BaseActivity {

    private Button btnConnect;
    private byte[] mCurValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConnect = findViewById(R.id.btn_connect);
        refresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    public void onClickScan(View view) {
        if (!SDKCmdManager.isConnected()) {
            if (checkPermission()) {
                SDKCmdManager.unbindWatch();
                //跳转到蓝牙扫描页面
                ActivityUtils.startActivity(ScanActivity.class);
            }
        } else {
            SDKCmdManager.unbindWatch();
        }
    }


    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            String[] permissions = new String[]{Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN};
            if (!PermissionUtils.isGranted(permissions)) {
                PermissionUtils.permission(permissions).request();
                return false;
            } else {
                return true;
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return checkLocation();
        } else {
            return true;
        }
    }

    private static boolean checkLocation() {
        if (!checkGpsSettings()) {
            return false;
        }
        if (!PermissionUtils.isGranted(PermissionConstants.LOCATION)) {
            PermissionUtils.permission(PermissionConstants.LOCATION).request();
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkGpsSettings() {
        if (!BleUtils.isEnableGps()) {
            Activity topActivity = ActivityUtils.getTopActivity();
            final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(topActivity);
            dialog.setMessage("请先开启GPS定位");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", (dialogInterface, i) -> {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivityUtils.startActivity(intent);
                dialogInterface.dismiss();
            });
            dialog.show();
            return false;
        }
        return true;
    }

    @Override
    public void onMessageEvent(Object event) {
        super.onMessageEvent(event);
        if (event instanceof ConnectStatusEvent) {
            refresh();
        } else if (event instanceof AckEvent) {
            AckEvent events = (AckEvent) event;
            boolean isCurAck = events.isCurrentAck(mCurValue);
            MyToast("isCurAck:" + isCurAck + ";操作结果:" + ((AckEvent) event).isSuccess());
        }
    }

    private void refresh() {
        btnConnect.setText(SDKCmdManager.isConnected() ? "设备已连接" : "连接设备");
    }

    public void onClickFind(View view) {
        if (!SDKCmdManager.isConnected()) {
            MyToast("请先连接设备");
            return;
        }
        mCurValue = SDKCmdManager.findWatch();
    }

    private void MyToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void onClickTestHeart(View view) {
        if (!SDKCmdManager.isConnected()) {
            MyToast("请先连接设备");
            return;
        }
        mCurValue = SDKCmdManager.testHeartRate(true);
    }

    public void onClickStopTestHeart(View view) {
        if (!SDKCmdManager.isConnected()) {
            MyToast("请先连接设备");
            return;
        }
        mCurValue = SDKCmdManager.testHeartRate(false);
    }
}