package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * IMEI返回事件
 */
public class IMEIEvent extends BaseEvent{
    private String imei;

    public IMEIEvent(String imei) {
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }
}
