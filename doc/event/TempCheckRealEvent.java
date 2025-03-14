package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.model.TempCheckModel;

import java.util.List;

/**
 * 自定义温度检测实时数据事件
 * @author yougaohui
 * @since 2025/3/10 11:05
 * @email 839939978@qq.com
 * @desciption
 **/
public class TempCheckRealEvent extends BaseEvent{
    TempCheckModel tempCheck;

    public TempCheckRealEvent(TempCheckModel tempCheck) {
        this.tempCheck = tempCheck;
    }

    public TempCheckModel getTempCheck() {
        return tempCheck;
    }
}
