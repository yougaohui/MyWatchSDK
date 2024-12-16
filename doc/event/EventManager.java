package com.legend.mywatch.sdk.mywatchsdklib.android.event;

import android.util.Log;

import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.Profile;

/**
 * 事件管理类
 */
public class EventManager {
    /**
     * 获取ack对应的类型
     *
     * @param command
     * @param commandKey
     * @return
     */
    public static int getMsgWhat(int command, int commandKey) {
        switch (command) {
            case Profile.PBSmartBandCommandId.PBSmartBandCommandIdStrappedEquipment:
                return Profile.MsgWhat.what10;
            case Profile.PBSmartBandCommandId.PBSmartBandCommandIdSport:
                switch (commandKey) {
                    case Profile.PBSmartBandCommandIdSportKeyId.PBSmartBandCommandIdSportKeyHistoryDataStart:
                        return Profile.MsgWhat.what11;
                    case Profile.PBSmartBandCommandIdSportKeyId.PBSmartBandCommandIdSportKeyHistoryDataEnd:
                        return Profile.MsgWhat.what12;
                    case Profile.PBSmartBandCommandIdSportKeyId.PBSmartBandCommandIdSportKeyDayDataRecive:
                        return Profile.MsgWhat.what5;
                    default:
                        return 0;
                }
            case Profile.PBSmartBandCommandId.PBSmartBandCommandIdDeviceReset:
                return Profile.MsgWhat.what13;
            case Profile.PBSmartBandCommandId.PBSmartBandCommandIdSetInfoByKey:
                return Profile.MsgWhat.what14;
            case Profile.PBSmartBandCommandId.PBSmartBandCommandIdSetting:
                switch (commandKey) {
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySycTime:
                        return Profile.MsgWhat.what30;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetUserInfo:
                        return Profile.MsgWhat.what31;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetStepTarget:
                        return Profile.MsgWhat.what32;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyAlarmClock:
                        return Profile.MsgWhat.what35;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetLongSitRemind:
                        return Profile.MsgWhat.what36;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetCallRemind: //设置是否来电提醒
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyTaishou: // 抬手亮屏
                        return Profile.MsgWhat.what37;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyLanguage:  // 语言设置（value：中文：0x00 英文：0x01）
                        return Profile.MsgWhat.what38;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyHeartRateSwitch:  // 心率测量开关(APP发起)（value：关闭：0x00 开始：0x01）
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyMeasure:  // 心率测量开关(APP发起)（value：关闭：0x00 开始：0x01）
                        return Profile.MsgWhat.what64;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyBloodPressureSwitch:  // 血压测量开关(APP发起)（value：关闭：0x00 开始：0x01）
                        return Profile.MsgWhat.what65;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingSpoSwitch:  // 血压测量开关(APP发起)（value：关闭：0x00 开始：0x01）
                        return Profile.MsgWhat.what68;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyBrightScreen:  // 抬腕亮屏设置
                        return Profile.MsgWhat.what39;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyDisturbSwitch:  // 勿扰模式开关以及有效时间段设置
                        return Profile.MsgWhat.what300;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyHeartAuto:   //睡眠开关设置和睡眠有效时间段设置
                        return Profile.MsgWhat.what301;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySleepSwitch:   //睡眠开关设置和睡眠有效时间段设置
                        return Profile.MsgWhat.what302;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetHandSide:  // 左右手设置
                        return Profile.MsgWhat.what40;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySycContracts:  // 添加联系人(APP发起)（value：关闭：0x00 开始：0x01）
                        return Profile.MsgWhat.what19;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyDelteContract:  // 删除联系人(APP发起)（value：关闭：0x00 开始：0x01）
                        return Profile.MsgWhat.what23;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyTempUnite:  // 温度单位
                        return Profile.MsgWhat.what25;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetTartSportTime:  // 设置目标运动时间
                        return Profile.MsgWhat.what91;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetTartStandTime:  // 设置站立目标
                        return Profile.MsgWhat.what92;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetSleepWarn:  // 睡眠提醒
                        return Profile.MsgWhat.what93;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetTimerHeart:  // 设置定时测量心率
                        return Profile.MsgWhat.what94;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetTargetKcal:  // 设置目标卡路里
                        return Profile.MsgWhat.what97;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyContractSOS:  // 设置紧急联系人
                        return Profile.MsgWhat.what24;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetDrinkWarn:// 饮水提醒
                        return Profile.MsgWhat.what98;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetGestureControl:  // 手势控制参数设置
                        return Profile.MsgWhat.what99;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetPhoneImei:  // imei号
                        return Profile.MsgWhat.what100;
                    case Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeySetNumOfOTA:  // OTA升级模块个数
                        return Profile.MsgWhat.what101;
                    default:
                }
            case Profile.PBSmartBandCommandId.PBSmartBandCommandIdOtherSetInfo:
                return Profile.MsgWhat.what33;
            case Profile.PBSmartBandCommandId.PBSmartBandCommandIdAlarmLists: //  闹钟列表
                return Profile.MsgWhat.what34;
        }
        return 0;
    }
}
