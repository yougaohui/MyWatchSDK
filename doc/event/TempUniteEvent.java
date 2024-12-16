package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 温度单位事件返回
 */
public class TempUniteEvent extends BaseEvent {
    //温度单位(0->℃,1->℉)
    private int tempUnite;

    public TempUniteEvent(int tempUnite) {
        this.tempUnite = tempUnite;
    }

    public int getTempUnite() {
        return tempUnite;
    }
}
