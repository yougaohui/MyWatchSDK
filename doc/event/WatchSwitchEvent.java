package com.legend.mywatch.sdk.mywatchsdklib.android.event;
/**
 * @author yougaohui
 * @since 2023/8/9 13:41
 * @email 839939978@qq.com
 * @desciption  表盘切换事件
 **/
public class WatchSwitchEvent extends BaseEvent{
    long watchId;//表盘ID
    int status;//0切换成功；1切换失败，未知错误；2:没发现表盘ID

    public WatchSwitchEvent(long watchId, int status) {
        this.watchId = watchId;
        this.status = status;
    }


    public long getWatchId() {
        return watchId;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "WatchSwitchEvent{" +
                "watchId=" + watchId +
                ", status=" + status +
                '}';
    }
}
