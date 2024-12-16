package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 电量事件
 */
public class BatteryEvent extends BaseEvent{
    //电量
    private int battery;

    public BatteryEvent(int battery) {
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }
}
