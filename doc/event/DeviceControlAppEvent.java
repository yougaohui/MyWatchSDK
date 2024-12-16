package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import com.legend.mywatch.sdk.mywatchsdklib.android.enm.DeviceControlAppEnum;

/**
 * 设备控制app指令
 * 里面包含:拍照指令、退出远程拍照、进入远程拍照、退出心率测量
 * 退出血压测量、退出血氧测量、查找手机、停止查找手机、挂断电话
 * 接听电话、控制音乐上一首、控制音乐下一首、音乐暂停/播放、
 * 请求同步时间、请求获取imei
 *
 */
public class DeviceControlAppEvent extends BaseEvent {

    private DeviceControlAppEnum deviceControlAppEnum;

    public DeviceControlAppEvent(DeviceControlAppEnum deviceControlAppEnum) {
        this.deviceControlAppEnum = deviceControlAppEnum;
    }

    public DeviceControlAppEnum getDeviceControlAppEnum() {
        return deviceControlAppEnum;
    }
}
