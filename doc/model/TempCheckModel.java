package com.legend.mywatch.sdk.mywatchsdklib.android.model;

import java.util.Date;

/**
 * 温度检测模型
 */
public class TempCheckModel {
   private int timestamp;//时间戳，单位分钟，从当前0时算起
   private float temperature;//温度，单位摄氏度
   private int powerOnCount;//开机次数
   private Date connectedDate;//连接时间
   private String mac;//后面7位mac地址

    public TempCheckModel(int timestamp, int temperature, int powerOnCount, Date connectedDate, String mac) {
        this.timestamp = timestamp;
        this.temperature = temperature/100f;
        this.powerOnCount = powerOnCount;
        this.connectedDate = connectedDate;
        this.mac = mac;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getPowerOnCount() {
        return powerOnCount;
    }

    public Date getConnectedDate() {
        return connectedDate;
    }

    public String getMac() {
        return mac;
    }

    @Override
    public String toString() {
        return "TempCheckModel{" +
                "timestamp=" + timestamp +
                ", temperature=" + temperature +
                ", index=" + powerOnCount +
                ", connectedDate=" + connectedDate +
                ", mac='" + mac + '\'' +
                '}';
    }
}
