package com.legend.mywatch.sdk.android.scan;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.view.View;
import android.widget.TextView;

import com.legend.mywatch.sdk.android.R;
import com.legend.mywatch.sdk.android.base.adapter.BaseHolder;
import com.legend.mywatch.sdk.android.base.adapter.DefaultAdapter;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.StringUtils;

import java.util.List;

import no.nordicsemi.android.support.v18.scanner.ScanResult;

@SuppressLint("MissingPermission")
public class ScanAdapter extends DefaultAdapter<ScanResult> {
    public ScanAdapter(List<ScanResult> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<ScanResult> getHolder(View v, int viewType) {
        return new MyHodler(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_scan;
    }

    private class MyHodler extends BaseHolder<ScanResult> {
        private final TextView name;
        private final TextView mac;
        private final TextView rssi;

        public MyHodler(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            mac = v.findViewById(R.id.mac);
            rssi = v.findViewById(R.id.rrsi);
        }

        @Override
        public void setData(ScanResult data, int position) {
            BluetoothDevice device = data.getDevice();
            String deviceName = device.getName();
            name.setText(StringUtils.isEmpty(deviceName) ? "N/A" : deviceName);
            mac.setText(device.getAddress());
            rssi.setText(String.valueOf(data.getRssi()));
        }
    }
}
