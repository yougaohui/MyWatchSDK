package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import java.util.Date;

/**
 * 血氧返回事件
 */
public class MeasureSpoEvent extends BaseEvent{
    Date date;
    int spo;

    public MeasureSpoEvent(Date date, int spo) {
        this.date = date;
        this.spo = spo;
    }

    public Date getDate() {
        return date;
    }

    public int getSpo() {
        return spo;
    }
}
