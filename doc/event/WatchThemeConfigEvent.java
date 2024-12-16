package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.watchtheme.MixStyleModel;

import java.util.Arrays;
import java.util.List;

/**
 * @author yougaohui
 * @email 839939978@qq.com
 * @desciption 表盘信息配置
 * @since 2023/11/3 14:18
 **/
public class WatchThemeConfigEvent extends BaseEvent{
    long watchId;//表盘ID
    int innerBgStyleIndex;//内置背景序列号
    int timeStyleIndex;//时间样式序列号

    List<MixStyleModel> mixStyles;//复杂样式集合
    byte[] bgColor;//背景色配置
    byte deviceTyp;//设备发送类型 0设备主动返回，1app主动获取

    boolean isSuccess = true;//正常协议
    Exception exception;//异常信息

    public WatchThemeConfigEvent(Exception exception) {
        this.isSuccess = false;
        this.exception = exception;
    }

    public WatchThemeConfigEvent(long watchId, int innerBgStyleIndex, int timeStyleIndex, List<MixStyleModel> mixStyles, byte[] bgColor, byte deviceTyp) {
        this.watchId = watchId;
        this.innerBgStyleIndex = innerBgStyleIndex;
        this.timeStyleIndex = timeStyleIndex;
        this.mixStyles = mixStyles;
        this.bgColor = bgColor;
        this.deviceTyp = deviceTyp;
    }

    public long getWatchId() {
        return watchId;
    }

    public int getInnerBgStyleIndex() {
        return innerBgStyleIndex;
    }

    public int getTimeStyleIndex() {
        return timeStyleIndex;
    }

    public List<MixStyleModel> getMixStyles() {
        return mixStyles;
    }

    public byte[] getBgColor() {
        return bgColor;
    }

    public byte getDeviceTyp() {
        return deviceTyp;
    }


    public boolean isSuccess() {
        return isSuccess;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return "WatchThemeConfigEvent{" +
                "watchId=" + watchId +
                ", innerBgStyleIndex=" + innerBgStyleIndex +
                ", timeStyleIndex=" + timeStyleIndex +
                ", mixStyles=" + mixStyles +
                ", bgColor=" + Arrays.toString(bgColor) +
                ", deviceTyp=" + deviceTyp +
                '}';
    }
}
