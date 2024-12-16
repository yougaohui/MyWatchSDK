package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 目标步数返回事件
 */
public class TargetStepsEvent extends BaseEvent{
    private int targetSteps;
    public TargetStepsEvent(int targetSteps) {
        this.targetSteps = targetSteps;
    }
    public int getTargetSteps() {
        return targetSteps;
    }
}
