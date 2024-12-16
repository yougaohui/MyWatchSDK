package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/**
 * 设备远程控制app枚举
 */
public enum DeviceControlAppEnum {
    //远程拍照指令
    TAKE_PHOTO(0),
    //退出远程拍照
    EXIT_REMOTE_CAMERA(1),
    //进入远程拍照
    ENTER_REMOTE_CAMERA(2),
    //退出心率测量
    EXIT_HEART_AUTO(3),
    //退出血压测量
    EXIT_BLOOD_PRESSURE(4),
    // 退出血氧测量
    EXIT_BLOOD_OXYGEN(5),
    // 查找手机
    FIND_PHONE(6),
    // 停止查找手机
    STOP_FIND_PHONE(7),
    // 挂断电话
    HANG_UP(8),
    // 接听电话
    ANSWER(9),
    // 控制音乐上一首
    PREVIOUS(10),
    // 控制音乐下一首
    NEXT(11),
    // 音乐暂停/播放
    PLAY_PAUSE(12),
    // 同步时间
    SYNCHRONIZE_TIME(13),
    // 获取imei
    GET_IMEI(14),
    ;

    int type;

    DeviceControlAppEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
