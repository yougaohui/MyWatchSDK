package com.legend.mywatch.sdk.mywatchsdklib.android.event;


import java.util.Date;

/**
 * 睡眠数据返回事件
 * Created by gaohui.you on 2019/5/29 0029
 * Email:839939978@qq.com
 */
public class SleepDetailsEvent extends BaseEvent {
    Date date;//睡眠时间
    int sleepType;//睡眠类型,>>1到2是或者1到FF都是浅睡时间 >>2到1是深睡时间 >>FF到1是清醒时间
    String devid;//设备id,用的设备mac地址

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSleepType() {
        return sleepType;
    }

    public void setSleepType(int sleepType) {
        this.sleepType = sleepType;
    }

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }

}
