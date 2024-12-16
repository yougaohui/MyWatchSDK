package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 删除表盘事件
 */
public class WatchDeleteEvent extends BaseEvent{
    long watchId;//表盘ID
    int status;//0删除成功；1删除失败，未知错误；2删除失败，已经超过表盘下限

    public WatchDeleteEvent(long watchId, int status) {
        this.watchId = watchId;
        this.status = status;
    }


    public long getWatchId() {
        return watchId;
    }

    public int getStatus() {
        return status;
    }
}
