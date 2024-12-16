package com.legend.mywatch.sdk.mywatchsdklib.android.event;


import com.legend.mywatch.sdk.mywatchsdklib.android.watchtheme.ClockDialInfoBody;

/**
 * 表盘信息事件
 * Created by gaohui.you on 2020/6/12 0012
 * Email:839939978@qq.com
 */
public class ClockDialInfoEvent extends BaseEvent{
    ClockDialInfoBody mBody;//表盘信息
    String mErrorInfo;//错误信息

    public ClockDialInfoEvent(ClockDialInfoBody body, String errorInfo) {
        mBody = body;
        mErrorInfo = errorInfo;
    }

    public ClockDialInfoBody getBody() {
        return mBody;
    }

    public String getErrorInfo() {
        return mErrorInfo;
    }
}
