package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/**
 * 表盘样式枚举
 */
public enum WatchThemeStyleEnum {
    //    0->拍照照片;1->背景颜色;2->背景样式;3->时间样式;4->指针样式;5->复杂功能一;6->复杂功能二;
    TAKE_PICTURE(0, "拍照照片"),
    BG_COLOR(1, "背景颜色"),
    BG_STYLE(2, "背景样式"),
    TIME_STYLE(3, "时间样式"),
    POINTER_STYLE(4, "指针样式"),
    MIX_FUNCTION_1(5, "复杂功能一"),
    MIX_FUNCTION_2(6, "复杂功能二");

    int type;
    String label;

    WatchThemeStyleEnum(int type, String label) {
        this.type = type;
        this.label = label;
    }

    public int getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }
}
