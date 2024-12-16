package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 左右手佩戴事件
 */
public class HandsEvent extends BaseEvent{
    //是否是右手，true表示右手
    private boolean isRightHand;

    public HandsEvent(boolean isRightHand) {
        this.isRightHand = isRightHand;
    }
    public boolean isRightHand() {
        return isRightHand;
    }
}
