package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.utils.TimeUtils;

import java.util.Date;

/**
 * 心率返回事件
 */
public class MeasureHeartEvent extends BaseEvent {
    Date date = TimeUtils.getNowDate();
    int heart;//心率
    byte status;//心率状态，0:普通心率;1:静息心率;2:连续心率（只做显示不做存储）

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
