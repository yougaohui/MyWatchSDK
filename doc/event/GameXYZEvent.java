package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 体感游戏x,y,z返回事件
 */
public class GameXYZEvent extends BaseEvent{
    int x, y, z;

    public GameXYZEvent(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "GameXYZEvent{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
