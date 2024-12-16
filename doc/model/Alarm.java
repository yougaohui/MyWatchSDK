package com.legend.mywatch.sdk.mywatchsdklib.android.model;

/**
 * 闹钟
 */
public class Alarm {
    private long year;//年
    private long month;//月
    private long day;//日
    private long hour;//时
    private long minute;//分
    private long num;//重复次数，默认1，禁用
    private byte[] weeks;//0~6bit 周一到周日

    public Alarm(long year, long month, long day, long hour, long minute, long num, byte[] weeks) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.num = num;
        this.weeks = weeks;
    }

    public long getYear() {
        return year;
    }

    public long getMonth() {
        return month;
    }

    public long getDay() {
        return day;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getNum() {
        return num;
    }

    public byte[] getWeeks() {
        return weeks;
    }
}
