package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * OTA 升级地址，用途不明，正常不会使用
 */
public class OTAUpgradeEvent extends BaseEvent {
    private byte[] data;

    public OTAUpgradeEvent(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}
