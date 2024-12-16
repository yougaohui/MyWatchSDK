package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 目标站立时间返回事件
 */
public class TargetStandEvent extends BaseEvent{
    //目标站立时间，单位小时
    private int targetStandTime;

    public TargetStandEvent(int targetStandTime) {
        this.targetStandTime = targetStandTime;
    }

    public int getTargetStandTime() {
        return targetStandTime;
    }
}
