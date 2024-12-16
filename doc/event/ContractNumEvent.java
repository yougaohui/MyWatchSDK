package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 通讯录个数事件
 * Created by gaohui.you on 2020/3/3 0003
 * Email:839939978@qq.com
 */
public class ContractNumEvent extends BaseEvent{
    int num;//当前通讯录个数
    int maxNum;//最大通讯录个数

    public ContractNumEvent(int num, int maxNum) {
        this.num = num;
        this.maxNum = maxNum;
    }

    public int getNum() {
        return num;
    }

    public int getMaxNum() {
        return maxNum;
    }

    @Override
    public String toString() {
        return "ContractNumEvent{" +
                "num=" + num +
                ", maxNum=" + maxNum +
                '}';
    }
}
