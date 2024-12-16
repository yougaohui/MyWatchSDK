package com.legend.mywatch.sdk.mywatchsdklib.android.event;


import com.legend.mywatch.sdk.mywatchsdklib.android.watchtheme.Watch3;

import java.util.List;

/**
 * 表盘列表事件，用于获取当前手表的表盘列表
 */
public class WatchListEvent extends BaseEvent{
    List<Watch3> watch3List;

    boolean isPreset;//true->预设表盘

    public WatchListEvent(List<Watch3> watch3List, boolean isPreset) {
        this.watch3List = watch3List;
        this.isPreset = isPreset;
    }

    public List<Watch3> getWatch3List() {
        return watch3List;
    }

    public boolean isPreset() {
        return isPreset;
    }
}
