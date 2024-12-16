package com.legend.mywatch.sdk.mywatchsdklib.android.event;


/**
 * 硬件信息，用于调试硬件状态
 * Created by gaohui.you on 2021/7/6 0006
 * Email:839939978@qq.com
 */
public class DeviceHardInfoEvent extends BaseEvent {
    private String led; //LED状态
    private String gsensor;//gsensor状态
    private String heart;//心率

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led;
    }

    public String getGsensor() {
        return gsensor;
    }

    public void setGsensor(String gsensor) {
        this.gsensor = gsensor;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    @Override
    public String toString() {
        return "DeviceHardInfoEvent{" +
                "led='" + led + '\'' +
                ", gsensor='" + gsensor + '\'' +
                ", heart='" + heart + '\'' +
                '}';
    }
}
