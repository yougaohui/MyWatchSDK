package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/**
 * 来电状态枚举
 */
public enum CallStatusEnm {
    CALL_STATE_IDLE(0),//挂断
    CALL_STATE_RINGING(1),//响铃
    CALL_STATE_OFFHOOK(2),//接电话
    CALL_STATE_DEFAULT(-1),//默认
    ;

    private int value;

    CallStatusEnm(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

