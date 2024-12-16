package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 抬腕亮屏事件
 */
public class BrightScreenEvent extends BaseEvent {
    //抬腕开关,true表示开启
    boolean isSwitchOn;
    //抬腕开始时间,从0点开始计算 单位分钟
    int startTime;
    //抬腕结束时间,从0点开始计算 单位分钟
    int endTime;

    public boolean isSwitchOn() {
        return isSwitchOn;
    }

    public void setSwitchOn(boolean switchOn) {
        isSwitchOn = switchOn;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BrightScreenEvent{" +
                "isSwitchOn=" + isSwitchOn +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
