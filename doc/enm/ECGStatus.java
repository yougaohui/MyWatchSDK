package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/**
 * 心电状态
 */
public enum ECGStatus {
    STOP(0),//测试完成
    START(1);//开始测试心电
    int status;

    ECGStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
