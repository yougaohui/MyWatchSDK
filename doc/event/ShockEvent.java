package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 震动开关状态事件
 */
public class ShockEvent extends BaseEvent{
    //是否开启震动模式
    private boolean isOpenShockMode;//true表示开启

    public ShockEvent(boolean isOpenShockMode) {
        this.isOpenShockMode = isOpenShockMode;
    }

    public boolean isOpenShockMode() {
        return isOpenShockMode;
    }
}
