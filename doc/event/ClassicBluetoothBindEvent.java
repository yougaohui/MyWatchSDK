package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 经典蓝牙绑定事件
 */
public class ClassicBluetoothBindEvent extends BaseEvent {

    //蓝牙mac地址
    private String macAddress;

    public ClassicBluetoothBindEvent(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }
}
