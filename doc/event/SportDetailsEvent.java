package com.legend.mywatch.sdk.mywatchsdklib.android.event;


import java.util.Date;

/**
 * 历史步数返回事件
 * Created by gaohui.you on 2019/5/28 0028
 * Email:839939978@qq.com
 */
public class SportDetailsEvent extends BaseEvent{
    int calory;//卡路里
    int mode;//这字段代码没用到，暂时不知道什么意思，保留
    int step;//步数
    int distance;//运动距离
    int activeTime;//这字段也没用到，暂时保留
    Date date;//运动时间
    boolean isLastHistory = false;//最近历史步数
    int targetSteps;//目标步数

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(int activeTime) {
        this.activeTime = activeTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public boolean isLastHistory() {
        return isLastHistory;
    }

    public void setLastHistory(boolean lastHistory) {
        isLastHistory = lastHistory;
    }

    public int getTargetSteps() {
        return targetSteps;
    }

    public void setTargetSteps(int targetSteps) {
        this.targetSteps = targetSteps;
    }
}
