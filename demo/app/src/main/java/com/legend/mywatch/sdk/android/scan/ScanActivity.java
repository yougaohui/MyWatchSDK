package com.legend.mywatch.sdk.android.scan;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.legend.mywatch.sdk.android.R;
import com.legend.mywatch.sdk.android.base.adapter.BaseActivity;
import com.legend.mywatch.sdk.android.base.adapter.DefaultAdapter;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.ConnectStatusEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.sdk.SDKCmdManager;
import com.legend.mywatch.sdk.mywatchsdklib.android.sdk.WatchSDK;

import java.util.ArrayList;
import java.util.List;

import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

@SuppressLint("MissingPermission")
public class ScanActivity extends BaseActivity {

    private RecyclerView list;
    private ScanAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        WatchSDK.getSDK().getConfig().setReconnect(false);//禁止回连
        list = findViewById(R.id.list);
        SwipeRefreshLayout refresh = findViewById(R.id.swipe_refresh);
        adapter = new ScanAdapter(new ArrayList<>());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener((DefaultAdapter.OnRecyclerViewItemClickListener<ScanResult>) (view, viewType, data, position) -> {
            SDKCmdManager.connectWatch(data.getDevice().getAddress());
        });
        refresh.setOnRefreshListener(() -> {
            adapter.getInfos().clear();
            stopScan();
            startScan();
            refresh.setRefreshing(false);
        });
    }


    private static long lastClickTime = 0;//上次点击的时间
    private static int spaceTime = 3000;//时间间隔

    public static boolean isFastScan() {
        long currentTime = System.currentTimeMillis();//当前系统时间
        boolean isFastClick;//是否允许点击
        if (currentTime - lastClickTime > spaceTime) {
            isFastClick = false;
        } else {
            isFastClick = true;
        }
        lastClickTime = currentTime;
        return isFastClick;
    }


    private boolean isStartScan = false;

    /**
     * Start scanning for Bluetooth devices.
     */
    public void startScan() {
        if (isStartScan) {
            return;
        }
        final ScanSettings settings = new ScanSettings.Builder().setLegacy(false).setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).setUseHardwareBatchingIfSupported(false).build();
        final BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
        scanner.stopScan(scanCallback);
        scanner.startScan(null, settings, scanCallback);
        isStartScan = true;
    }

    /**
     * Stop scanning for bluetooth devices.
     */
    public void stopScan() {
        if (isStartScan) {
            final BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
            scanner.stopScan(scanCallback);
            isStartScan = false;
        }
    }


    private final no.nordicsemi.android.support.v18.scanner.ScanCallback scanCallback = new no.nordicsemi.android.support.v18.scanner.ScanCallback() {
        @Override
        public void onScanResult(final int callbackType, @NonNull final ScanResult result) {
            //过滤掉名字为空的设备
            if (result.getDevice().getName() == null) {
                return;
            }
            // 快速点击过滤
            runOnUiThread(() -> {
                List<ScanResult> scanResults = adapter.getInfos();
                //判断是否有重复的mac地址
                for (ScanResult scanResult : scanResults) {
                    if (scanResult.getDevice().getAddress().equalsIgnoreCase(result.getDevice().getAddress())) {
                        return;
                    }
                }
                scanResults.add(result);
                //按照信号强度排序
                scanResults.sort((o1, o2) -> Integer.compare(o2.getRssi(), o1.getRssi()));
                adapter.notifyDataSetChanged();
            });

        }

        @Override
        public void onBatchScanResults(@NonNull final List<ScanResult> results) {
        }

        @Override
        public void onScanFailed(final int errorCode) {
            if (errorCode == no.nordicsemi.android.support.v18.scanner.ScanCallback.SCAN_FAILED_APPLICATION_REGISTRATION_FAILED) {
                stopScan();
                startScan();
            }
        }
    };

    @Override
    public void onMessageEvent(Object event) {
        super.onMessageEvent(event);
        if (event instanceof ConnectStatusEvent) {
            ConnectStatusEvent statusEvent = (ConnectStatusEvent) event;
            if (statusEvent.getStatus() == ConnectStatusEvent.STATUS_CONNECTED) {
                stopScan();
                finish();
            } else {
                Toast.makeText(this, "连接失败:" + statusEvent.getStatus(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopScan();
        WatchSDK.getSDK().getConfig().setReconnect(true);//回复回连
    }
}