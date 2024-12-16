package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.model.Alarm;

import java.util.List;

/**
 * 闹钟列表事件
 */
public class AlarmListsEvent extends BaseEvent{
    List<Alarm> alarmList;

    public AlarmListsEvent(List<Alarm> alarmList) {
        this.alarmList = alarmList;
    }

    public List<Alarm> getAlarmList() {
        return alarmList;
    }
}
