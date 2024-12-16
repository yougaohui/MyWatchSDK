package com.legend.mywatch.sdk.mywatchsdklib.android.event;


import java.util.Date;


/**
 * 温度数据返回事件
 */
public class TempEvent extends BaseEvent{
    Date measureTime;
    float tmp;//单位 ℃

    public TempEvent(Date measureTime, float tmp) {
        this.measureTime = measureTime;
        this.tmp = tmp;
    }

    public Date getMeasureTime() {
        return measureTime;
    }

    public float getTmp() {
        return tmp;
    }
}
