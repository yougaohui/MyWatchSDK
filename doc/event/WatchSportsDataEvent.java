package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import java.util.Date;

/**
 * 多运动数据返回
 */
public class WatchSportsDataEvent extends BaseEvent {
    Date date;//运动时间
    int sportMode;//运动模式,SportsConstant有对不同运动模式说明
    int duration;//运动时间 单位秒
    int totalKm;//总公里（单位米）
    int totalKcal;//总卡路里
    int avgHeartRate;//平均心率
    int steps;//步数
    int minHeart;//最小心率
    int maxHeart;//最大心率
    int jumpNum;//跳绳个数

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSportMode() {
        return sportMode;
    }

    public void setSportMode(int sportMode) {
        this.sportMode = sportMode;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(int totalKm) {
        this.totalKm = totalKm;
    }

    public int getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(int totalKcal) {
        this.totalKcal = totalKcal;
    }

    public int getAvgHeartRate() {
        return avgHeartRate;
    }

    public void setAvgHeartRate(int avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getMinHeart() {
        return minHeart;
    }

    public void setMinHeart(int minHeart) {
        this.minHeart = minHeart;
    }

    public int getMaxHeart() {
        return maxHeart;
    }

    public void setMaxHeart(int maxHeart) {
        this.maxHeart = maxHeart;
    }

    public int getJumpNum() {
        return jumpNum;
    }

    public void setJumpNum(int jumpNum) {
        this.jumpNum = jumpNum;
    }
}
