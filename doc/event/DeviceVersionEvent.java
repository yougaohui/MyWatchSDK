package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 软件版本号事件;返回设备的软件版本号
 */
public class DeviceVersionEvent extends BaseEvent{
    //软件版本号
    private String softwareVersion;

    public DeviceVersionEvent(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }
}
