package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 设备特征事件；用于特殊情况区分不同平台使用
 */
public class DeviceFeatureEvent extends BaseEvent{
    //特征
    private String feature;

    public DeviceFeatureEvent(String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }
}
