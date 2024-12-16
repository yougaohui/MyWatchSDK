package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 定时测量心率事件
 */
public class TimerTestHeartRateEvent extends BaseEvent {
    //定时测量心率时间,单位分钟
    private int time;

    public TimerTestHeartRateEvent(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
