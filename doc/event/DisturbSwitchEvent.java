package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import androidx.annotation.NonNull;

/**
 * 勿扰模式配置事件
 */
public class DisturbSwitchEvent extends BaseEvent{
    //勿扰开关
    private boolean isOpen;
    //勿扰开始时间,从0点开始计算 单位分钟
    private int startTime;
    //勿扰结束时间,从0点开始计算 单位分钟
    private int endTime;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
