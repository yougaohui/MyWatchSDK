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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.blankj.utilcode.util.GsonUtils;
import com.legend.mywatch.sdk.android.base.adapter.BaseActivity;
import com.legend.mywatch.sdk.android.event.LogEvent;
import com.legend.mywatch.sdk.android.scan.ScanActivity;
import com.legend.mywatch.sdk.android.utils.SaveLog2LocalUtils;
import com.legend.mywatch.sdk.android.utils.ShareUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.BuildConfig;
import com.legend.mywatch.sdk.mywatchsdklib.android.constant.PermissionConstants;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.AckEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.ConnectStatusEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.TempCheckHistoryEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.TempCheckRealEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.TempCheckTestEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.model.TempCheckModel;
import com.legend.mywatch.sdk.mywatchsdklib.android.model.TempCheckTestModel;
import com.legend.mywatch.sdk.mywatchsdklib.android.sdk.SDKCmdManager;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.ActivityUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.BleUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.CollectionUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.FileUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.LogUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.PermissionUtils;

import java.io.File;
import java.util.List;

@SuppressLint("MissingInflatedId")
public class MainActivity extends BaseActivity {

    private Button btnConnect;
    private byte[] mCurValue;
    private EditText edtLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConnect = findViewById(R.id.btn_connect);
        edtLog = findViewById(R.id.edt_log);
        //tv_version
        ((TextView) findViewById(R.id.tv_version)).setText("版本:" + BuildConfig.VERSION_NAME);
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
        } else if (event instanceof TempCheckHistoryEvent) {
            TempCheckHistoryEvent historyEvent = (TempCheckHistoryEvent) event;
            List<TempCheckModel> list = historyEvent.getTempCheck();
            StringBuilder sb = new StringBuilder("温度检测历史数据:\n");
            for (TempCheckModel model : list) {
                sb.append("时间戳: ").append(model.getTimestamp()).append("分钟\n");
                sb.append("温度: ").append(model.getTemperature()).append("℃\n");
                sb.append("开机次数: ").append(model.getPowerOnCount()).append("\n");
                sb.append("心率PPI: ").append(model.getHeartRatePPI()).append("\n");
                sb.append("风险状态: ").append(model.getRiskStatusText()).append("\n");
                byte[] extraData = model.getExtraData();
                sb.append("额外数据: ").append(extraData != null ? extraData.length + "字节" : "无").append("\n");
                sb.append("---\n");
            }
            showTempCheckDialog("温度检测历史数据", sb.toString());
        } else if (event instanceof TempCheckRealEvent) {
            TempCheckRealEvent realEvent = (TempCheckRealEvent) event;
            TempCheckModel model = realEvent.getTempCheck();
            StringBuilder sb = new StringBuilder();
            sb.append("时间戳: ").append(model.getTimestamp()).append("分钟\n");
            sb.append("温度: ").append(model.getTemperature()).append("℃\n");
            sb.append("开机次数: ").append(model.getPowerOnCount()).append("\n");
            sb.append("心率PPI: ").append(model.getHeartRatePPI()).append("\n");
            sb.append("风险状态: ").append(model.getRiskStatusText()).append("\n");
            byte[] extraData = model.getExtraData();
            sb.append("额外数据: ").append(extraData != null ? extraData.length + "字节" : "无").append("\n");
            showTempCheckDialog("实时温度检测", sb.toString());
        } else if (event instanceof TempCheckTestEvent) {
            MyToast(GsonUtils.toJson(event));
            //event
            TempCheckTestEvent aa = (TempCheckTestEvent) event;
            List<TempCheckTestModel> list = aa.getTempCheck();
            for (TempCheckTestModel tempCheckTestModel : list) {
                int time = tempCheckTestModel.getTimestamp();//Timestamp, in minutes
                int ppg = tempCheckTestModel.getPpg();//ppg
            }
        } else if (event instanceof LogEvent) {
            String log = ((LogEvent) event).getLog();
            if (log.contains("收到数据包")) {
                edtLog.setText(log);
                SaveLog2LocalUtils.saveLog(log);
            }
        }
    }

    private void showTempCheckDialog(String title, String content) {
        new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(content)
            .setPositiveButton("确定", null)
            .setCancelable(true)
            .show();
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
        LogUtils.i(TAG, "MyToast==============>>" + text);
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

    public void onClickGetHistory(View view) {
        if (!SDKCmdManager.isConnected()) {
            MyToast("请先连接设备");
            return;
        }
        mCurValue = SDKCmdManager.getTotalSportData();
    }

    //onClickDisconnect
    public void onClickDisconnect(View view) {
        if (!SDKCmdManager.isConnected()) {
            MyToast("请先连接设备");
            return;
        }
        SDKCmdManager.disconnectWatch();
    }

    //onClickUnbind
    public void onClickUnbind(View view) {
        if (!SDKCmdManager.isConnected()) {
            MyToast("请先连接设备");
            return;
        }
        SDKCmdManager.unbindWatch();
    }

    //onClickLog
    public void onClickLog(View view) {
        ActivityUtils.startActivity(LogActivity.class);
    }

    public void onClickExportLog(View view) {
        String logPath = SaveLog2LocalUtils.getDefaultPath();
        List<File> fileList = FileUtils.listFilesInDir(logPath);
        if (!CollectionUtils.isEmpty(fileList)) {
            ShareUtils.shareFiles(fileList);
        } else {
            MyToast("日志文件不存在");
        }
    }
}