package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.model.TempCheckModel;

import java.util.List;

/**
 * 自定义温度检测历史数据事件
 * @author yougaohui
 * @since 2025/3/10 11:05
 * @email 839939978@qq.com
 * @desciption
 **/
public class TempCheckHistoryEvent extends BaseEvent{
    List<TempCheckModel> tempCheck;

    public TempCheckHistoryEvent(List<TempCheckModel> tempCheck) {
        this.tempCheck = tempCheck;
    }

    public List<TempCheckModel> getTempCheck() {
        return tempCheck;
    }
}
