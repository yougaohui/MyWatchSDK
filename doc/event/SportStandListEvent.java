package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.model.SportStand;

import java.util.List;

/**
 * 站立列表返回事件
 */
public class SportStandListEvent extends BaseEvent {
    List<SportStand> standList;

    public SportStandListEvent(List<SportStand> standList) {
        this.standList = standList;
    }

    public List<SportStand> getStandList() {
        return standList;
    }

}
