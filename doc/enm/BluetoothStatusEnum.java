package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/**
 * 蓝牙状态
 */
public enum BluetoothStatusEnum {
    // 蓝牙连接状态 -3主服务不正确异常断开,-2设备不支持蓝牙, -1蓝牙未打开, 0未连接, 1 已连接, 2 正在连
    MAIN_SERVICE_NOT_MATCH(-3), NOT_SUPPORT_BLUETOOTH(-2), BLUETOOTH_NOT_OPENED(-1), DISCONNECT(0), CONNECTED(1), CONNECTING(2);

    private int value;

    BluetoothStatusEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
