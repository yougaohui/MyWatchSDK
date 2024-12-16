package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 目标卡路里返回事件
 */
public class TargetCalEvent extends BaseEvent{
    //目标卡路里，单位大卡
    private int targetCal;

    public TargetCalEvent(int targetCal) {
        this.targetCal = targetCal;
    }

    public int getTargetCal() {
        return targetCal;
    }
}
