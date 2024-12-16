package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 实时步数返回事件
 */
public class RealStepsEvent extends BaseEvent{
    //距离，单位米
    private int distance;
    //卡路里，单位大卡
    private int calories;
    //步数
    private int steps;
    //锻炼时长 单位分钟
    private int exerciseTime;
    //历史距离，单位米
    private int historyDistance;
    //历史卡路里，单位大卡
    private int historyCalories;
    //历史步数
    private int historySteps;
    //历史锻炼时长
    private int historyExerciseTime;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(int exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    public int getHistoryDistance() {
        return historyDistance;
    }

    public void setHistoryDistance(int historyDistance) {
        this.historyDistance = historyDistance;
    }

    public int getHistoryCalories() {
        return historyCalories;
    }

    public void setHistoryCalories(int historyCalories) {
        this.historyCalories = historyCalories;
    }

    public int getHistorySteps() {
        return historySteps;
    }

    public void setHistorySteps(int historySteps) {
        this.historySteps = historySteps;
    }

    public int getHistoryExerciseTime() {
        return historyExerciseTime;
    }

    public void setHistoryExerciseTime(int historyExerciseTime) {
        this.historyExerciseTime = historyExerciseTime;
    }
}
