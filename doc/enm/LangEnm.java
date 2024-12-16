package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/**
 * 语言枚举
 */
public enum LangEnm {
    //简体中文：0x00 英文：0x01 繁体：0x02 阿拉伯语：x03 捷克语：0x04 德语:0x05  西班牙语:0x06  法语:0x07  日语:0x08  马来西亚语:0x09  荷兰语:0xA  波兰语:0xB  葡萄牙语:0xC  俄语:0xD  斯洛伐克语:0xE  泰语:0xF  土耳其语:0x10 越南语:0x11 意大利语:0x12 菲律宾语:0x13 印尼语:0x14
//乌克兰语:0x15 印度语:0x16 芬兰语:0x17 克罗地亚语:0x18 挪威语:0x19  丹麦语:0x1A 瑞典语:0x1B  韩语:0x1C 匈牙利语:0x1D 希腊语:0x1E 波斯语:0x1F 罗马尼亚语:0x20  缅甸语:0x21  孟加拉语：0x22
    CHINESE_SIMPLIFIED(0x00, "简体中文"), ENGLISH(0x01, "英文"), TAIWAN(0x02, "繁体中文"), ALBANIAN(0x03, "阿拉伯语"), CZECH(0x04, "捷克语"), GERMAN(0x05, "德语"), SPANISH(0x06, "西班牙语"), FRENCH(0x07, "法语"), JAPANESE(0x08, "日语"), MALAYSIAN(0x09, "马来西亚语"), DUTCH(0x0A, "荷兰语"), POLISH(0x0B, "波兰语"), PORTUGUESE(0x0C, "葡萄牙语"), RUSSIAN(0x0D, "俄语"), SLOVAK(0x0E, "斯洛伐克语"), THAI(0x0F, "泰语"), GREEK(0x10, "希腊语"), VIETNAMESE(0x11, "越南语"), ITALIAN(0x12, "意大利语"), FILIPINO(0x13, "菲律宾语"), INDONESIAN(0x14, "印尼语"), UKRAINIAN(0x15, "乌克兰语"), INDIAN(0x16, "印度语"), FRENCH_BELGIAN(0x17, "芬兰语"), CROATIAN(0x18, "克罗地亚语"), NORWEGIAN(0x19, "挪威语"), DANISH(0x1A, "丹麦语"), SWEDISH(0x1B, "瑞典语"), KOREAN(0x1C, "韩语"), CZECH_REPUBLIC(0x1D, "匈牙利语"), GERMANY(0x1E, "希腊语"), BOSNIAN(0x1F, "波斯语"), ROMANIA(0x20, "罗马尼亚语"), MONGOLIAN(0x21, "缅甸语"), MONGOLIAN_CYRILLIC(0x22, "孟加拉语");

    private int value;
    private String desc;

    LangEnm(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}


