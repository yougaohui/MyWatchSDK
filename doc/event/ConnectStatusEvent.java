package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;

/**
 * 蓝牙连接状态事件
 */
public class ConnectStatusEvent extends BaseEvent {
    //蓝牙状态
    private int status;
    //设备mac地址
    private String macAddress;

    public ConnectStatusEvent(int status, String macAddress) {
        this.status = status;
        this.macAddress = macAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public int getStatus() {
        return status;
    }

    public boolean isConnected() {
        return status == BluetoothStatusEnum.CONNECTED.getValue();
    }

    // 蓝牙连接状态 -3主服务不正确异常断开,-2设备不支持蓝牙, -1蓝牙未打开, 0未连接, 1 已连接, 2 正在连
    public static final int STATUS_SERVICE_ERROR = BluetoothStatusEnum.MAIN_SERVICE_NOT_MATCH.getValue();
    public static final int STATUS_NOT_SUPPORT_BLUETOOTH = BluetoothStatusEnum.NOT_SUPPORT_BLUETOOTH.getValue();
    public static final int STATUS_BLUETOOTH_NOT_OPENED = BluetoothStatusEnum.BLUETOOTH_NOT_OPENED.getValue();
    public static final int STATUS_DISCONNECT = BluetoothStatusEnum.DISCONNECT.getValue();
    public static final int STATUS_CONNECTED = BluetoothStatusEnum.CONNECTED.getValue();
    public static final int STATUS_CONNECTING = BluetoothStatusEnum.CONNECTING.getValue();

}
