package com.legend.mywatch.sdk.mywatchsdklib.android.event;


import java.util.Date;


/**
 * 血压返回事件
 */
public class MeasureBloodEvent extends BaseEvent {
    Date date;
    int hBlood;//高血压
    int lBlood;//低血压

    public MeasureBloodEvent(Date date, int hBlood, int lBlood) {
        this.date = date;
        this.hBlood = hBlood;
        this.lBlood = lBlood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int gethBlood() {
        return hBlood;
    }

    public void sethBlood(int hBlood) {
        this.hBlood = hBlood;
    }

    public int getlBlood() {
        return lBlood;
    }

    public void setlBlood(int lBlood) {
        this.lBlood = lBlood;
    }
}
