package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 剩余空间查询
 */
public class WatchRemainEvent extends BaseEvent{
    long bytes;//设备剩余空间，单位byte

    public WatchRemainEvent(long bytes) {
        this.bytes = bytes;
    }

    public long getBytes() {
        return bytes;
    }
}
