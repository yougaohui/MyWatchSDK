package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 睡眠开关状态返回事件，目前未使用
 */
public class SleepStatusEvent extends BaseEvent {
    //睡眠开关 true 表示开启
    private boolean isSleepEnable;
    //睡眠开始时间 从0点开始计算 单位分钟
    private int sleepStartTime;
    //睡眠结束时间 从0点开始计算 单位分钟
    private int sleepEndTime;

    public boolean isSleepEnable() {
        return isSleepEnable;
    }

    public void setSleepEnable(boolean sleepEnable) {
        isSleepEnable = sleepEnable;
    }

    public int getSleepStartTime() {
        return sleepStartTime;
    }

    public void setSleepStartTime(int sleepStartTime) {
        this.sleepStartTime = sleepStartTime;
    }

    public int getSleepEndTime() {
        return sleepEndTime;
    }

    public void setSleepEndTime(int sleepEndTime) {
        this.sleepEndTime = sleepEndTime;
    }

    @Override
    public String toString() {
        return "SleepStatusEvent{" + "isSleepEnable=" + isSleepEnable + ", sleepStartTime=" + sleepStartTime + ", sleepEndTime=" + sleepEndTime + '}';
    }
}
