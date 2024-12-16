package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 喝水提醒配置返回事件
 */
public class DrinkConfigEvent extends BaseEvent {
    boolean isWarnOfDrink;//喝水提醒
    float durationOfDrinkWarn = 2;//喝水间隔时间 单位小时
    int startTimeOfWarn = 8 * 60;//开始提醒时间 单位分钟
    int finishTimeOfWarn = 20 * 60;//结束提醒时间 单位分钟
    boolean warnFinishOfToday;//当日完成后不再提醒

    public boolean isWarnOfDrink() {
        return isWarnOfDrink;
    }

    public void setWarnOfDrink(boolean warnOfDrink) {
        isWarnOfDrink = warnOfDrink;
    }

    public float getDurationOfDrinkWarn() {
        return durationOfDrinkWarn;
    }

    public void setDurationOfDrinkWarn(float durationOfDrinkWarn) {
        this.durationOfDrinkWarn = durationOfDrinkWarn;
    }

    public int getStartTimeOfWarn() {
        return startTimeOfWarn;
    }

    public void setStartTimeOfWarn(int startTimeOfWarn) {
        this.startTimeOfWarn = startTimeOfWarn;
    }

    public int getFinishTimeOfWarn() {
        return finishTimeOfWarn;
    }

    public void setFinishTimeOfWarn(int finishTimeOfWarn) {
        this.finishTimeOfWarn = finishTimeOfWarn;
    }

    public boolean isWarnFinishOfToday() {
        return warnFinishOfToday;
    }

    public void setWarnFinishOfToday(boolean warnFinishOfToday) {
        this.warnFinishOfToday = warnFinishOfToday;
    }
}
