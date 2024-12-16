package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 心电返回事件
 */
public class ECGRecordEvent extends BaseEvent{
    int status; //0=心电数据同步完成; 1=开始同步心电
    private int heartRate;//心电返回值

    public ECGRecordEvent(int status, int heartRate) {
        this.status = status;
        this.heartRate = heartRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ECGRecordModel{" +
                "heartRate=" + heartRate +
                '}';
    }
}


