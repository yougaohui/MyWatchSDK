package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 经典蓝牙名称事件
 */
public class ClassicBluetoothNameEvent extends BaseEvent {

    //经典蓝牙名称
    private String classicBluetoothName;

    public ClassicBluetoothNameEvent(String classicBluetoothName) {
        this.classicBluetoothName = classicBluetoothName;
    }

    public String getClassicBluetoothName() {
        return classicBluetoothName;
    }
}
