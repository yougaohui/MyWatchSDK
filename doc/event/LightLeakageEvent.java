package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 漏光测试返回事件;测试使用
 */
public class LightLeakageEvent extends BaseEvent{
    private int gr;
    private int ir;

    public LightLeakageEvent(int gr, int ir) {
        this.gr = gr;
        this.ir = ir;
    }

    public int getGr() {
        return gr;
    }

    public int getIr() {
        return ir;
    }

    @Override
    public String toString() {
        return "LightLeakageEvent{" +
                "gr=" + gr +
                ", ir=" + ir +
                '}';
    }
}
