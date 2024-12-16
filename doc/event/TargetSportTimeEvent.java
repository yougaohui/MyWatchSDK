package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 目标运动时间返回事件
 */
public class TargetSportTimeEvent extends BaseEvent {
    //目标运动时间
    private int targetSportTime;

    public TargetSportTimeEvent(int targetSportTime) {
        this.targetSportTime = targetSportTime;
    }

    public int getTargetSportTime() {
        return targetSportTime;
    }
}
