package com.legend.mywatch.sdk.mywatchsdklib.android.event;


/**
 * 睡眠提醒返回事件
 */
public class SleepWarnEvent extends BaseEvent{
    //睡眠提醒开关
    boolean isOpen;
    //星期;脚标0~6 = 周一到周日
    private byte[] weeks;
    //入睡时间，单位分钟，从0点开始算
    short startSleepTime;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public byte[] getWeeks() {
        return weeks;
    }

    public void setWeeks(byte[] weeks) {
        this.weeks = weeks;
    }

    public short getStartSleepTime() {
        return startSleepTime;
    }

    public void setStartSleepTime(short startSleepTime) {
        this.startSleepTime = startSleepTime;
    }
}
