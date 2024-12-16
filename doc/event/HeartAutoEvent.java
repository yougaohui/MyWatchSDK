package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 自动测量心率事件
 */
public class HeartAutoEvent extends BaseEvent {
    //心率开关
    private boolean isOpen;
    //心率辅助睡眠
    private boolean isAssistSleep;
    //心率测量频率
    private int heartRateFrequency;
    //心率开始时间 从0点开始计算 单位分钟
    private long startTime;
    //心率结束时间  从0点开始计算 单位分钟
    private long endTime;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isAssistSleep() {
        return isAssistSleep;
    }

    public void setAssistSleep(boolean assistSleep) {
        isAssistSleep = assistSleep;
    }

    public int getHeartRateFrequency() {
        return heartRateFrequency;
    }

    public void setHeartRateFrequency(int heartRateFrequency) {
        this.heartRateFrequency = heartRateFrequency;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "HeartAutoEvent{" + "isOpen=" + isOpen + ", isAssistSleep=" + isAssistSleep + ", heartRateFrequency=" + heartRateFrequency + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}
