package com.legend.mywatch.sdk.mywatchsdklib.android.model;

import java.util.Date;

/**
 * 站立事件返回
 */
public class SportStand {
    Date date;//站立时间
    int flag;//0未达成目标，1达成目标

    public SportStand(Date date, int flag) {
        this.date = date;
        this.flag = flag;
    }

    public Date getDate() {
        return date;
    }

    public int getFlag() {
        return flag;
    }
}
