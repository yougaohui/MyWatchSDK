package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 同步历史数据状态事件;包含开始同步历史数据与停驶同步历史数据两种状态
 */
public class SynHisDataEvent extends BaseEvent {
    boolean isSyncData;//true开始同步历史数据，false停止同步历史数据

    public SynHisDataEvent(boolean isSyncData) {
        this.isSyncData = isSyncData;
    }

    public boolean isSyncData() {
        return isSyncData;
    }
}
