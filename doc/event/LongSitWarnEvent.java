package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 久坐提醒事件
 */
public class LongSitWarnEvent extends BaseEvent {
    //久坐提醒 午休开关,true表示开启，部分设备没有这个功能，建议不使用
    boolean isLongSitWarnEnable;
    //久坐提醒 使能开关，true表示开启
    boolean isLongSitWarnSwitch;
    //久坐提醒 久坐时间，以15 分钟为单位， 最长为 2 小时，久坐超过这个时间，则提醒。比如 longSitWarnTime = 4,则久坐时长为15x4=60分钟
    int longSitWarnTime;
    //久坐提醒 开始提醒时间,以小时为单位,范围0~23
    int longSitWarnStartTime;
    //久坐结束提醒时间,以小时为单位,范围0~23
    int longSitWarnEndTime;

    public void setLongSitWarnEnable(boolean longSitWarnEnable) {
        isLongSitWarnEnable = longSitWarnEnable;
    }

    public void setLongSitWarnSwitch(boolean longSitWarnSwitch) {
        isLongSitWarnSwitch = longSitWarnSwitch;
    }


    public void setLongSitWarnTime(int longSitWarnTime) {
        this.longSitWarnTime = longSitWarnTime;
    }

    public void setLongSitWarnStartTime(int longSitWarnStartTime) {
        this.longSitWarnStartTime = longSitWarnStartTime;
    }

    public void setLongSitWarnEndTime(int longSitWarnEndTime) {
        this.longSitWarnEndTime = longSitWarnEndTime;
    }

    public boolean isLongSitWarnEnable() {
        return isLongSitWarnEnable;
    }

    public boolean isLongSitWarnSwitch() {
        return isLongSitWarnSwitch;
    }


    public int getLongSitWarnTime() {
        return longSitWarnTime;
    }

    public int getLongSitWarnStartTime() {
        return longSitWarnStartTime;
    }

    public int getLongSitWarnEndTime() {
        return longSitWarnEndTime;
    }

    @Override
    public String toString() {
        return "LongSitWarnEvent{" +
                "isLongSitWarnEnable=" + isLongSitWarnEnable +
                ", isLongSitWarnSwitch=" + isLongSitWarnSwitch +
                ", longSitWarnTime=" + longSitWarnTime +
                ", longSitWarnStartTime=" + longSitWarnStartTime +
                ", longSitWarnEndTime=" + longSitWarnEndTime +
                '}';
    }
}
