package com.legend.mywatch.sdk.android;

import android.app.Application;
import android.util.Log;

import com.blankj.utilcode.util.Utils;
import com.legend.mywatch.sdk.android.event.BytesEvent;
import com.legend.mywatch.sdk.android.event.LogEvent;
import com.legend.mywatch.sdk.android.utils.EventBusUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.sdk.Config;
import com.legend.mywatch.sdk.mywatchsdklib.android.sdk.WatchSDK;

import java.util.UUID;

public class App extends Application {
    //TAG
    private static final String TAG = "App";


    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        WatchSDK.getSDK().setConfig(new Config().setLogListener((tag, log) -> {//sdk日志回调
                            Log.i(tag, log);
                            EventBusUtils.post(new LogEvent(log));
                        }).setOriginalDataListener((data, uuid) -> {//原始数据流
                    EventBusUtils.post(new BytesEvent(data,uuid));
                        }).setReconnect(true)//是否重连，默认允许sdk回连
                        .setReconnectCheckInterval(30)//回连间隔,默认30s
        ).setOnEventListener(event -> {//设备返回数据事件回调
            Log.i(TAG, "=====>>event:" + event.toString());
            //AckEvent//每次发送指令到设备端，设备端收到指令后都会回复对应的ack，用于判断数据是否成功
            //AlarmListsEvent//闹钟列表事件
            //BatteryEvent//电量事件
            //BrightScreenEvent//抬腕亮屏事件
            //ClassicBluetoothBindEvent//经典蓝牙绑定事件
            //ClassicBluetoothNameEvent//经典蓝牙名称事件
            //ClockDialInfoEvent//表盘信息事件
            //ConnectStatusEvent//蓝牙连接状态事件
            //ContractNumEvent//通讯录个数事件
            //DeviceControlAppEvent//设备控制app指令,里面包含:拍照指令、退出远程拍照、进入远程拍照、退出心率测量，找手机等指令
            //DeviceFeatureEvent//设备特征事件；用于特殊情况区分不同平台使用
            //DeviceFunctionEvent//自定义功能事件;用于区分不同设备支持不同功能使用
            //DeviceHardInfoEvent//硬件信息，用于调试硬件状态
            //DeviceVersionEvent//软件版本号事件;返回设备的软件版本号
            //DisturbSwitchEvent//勿扰模式配置事件
            //DrinkConfigEvent//喝水提醒配置返回事件
            //ECGRecordEvent//心电返回事件
            //EnterWatchThemeEvent//进入表盘页面事件，设备主动请求app进入表盘
            //GameXYZEvent//体感游戏x,y,z返回事件
            //GestureControlConfigEvent//手势控制开关配置信息
            //HandsEvent//左右手佩戴事件
            //IMEIEvent //IMEI返回事件
            //LightLeakageEvent//漏光测试返回事件;测试使用
            //LongSitWarnEvent//久坐提醒事件
            //MeasureBloodEvent//血压返回事件
            //MeasureHeartEvent//心率返回事件
            //MeasureSpoEvent//血氧返回事件
            //MessageStatusEvent//消息提醒开关状态返回事件
            //OTAUpgradeEvent//OTA 升级地址，用途不明，正常不会使用
            //ProductInfoEvent//产品信息返回事件;主要用于显示产品图
            //RealStepsEvent//实时步数返回事件
            //ShockEvent//震动开关状态事件
            //SleepDetailsEvent//睡眠数据返回事件
            //SleepStatusEvent//睡眠开关状态返回事件，目前未使用
            //SleepWarnEvent//睡眠提醒返回事件
            //SportDetailsEvent//历史步数返回事件
            //SportStandListEvent//站立列表返回事件
            //SynHisDataEvent//同步历史数据状态事件;包含开始同步历史数据与停驶同步历史数据两种状态
            //TargetCalEvent//目标卡路里返回事件
            //TargetSportTimeEvent//目标运动时间返回事件
            //TargetStandEvent//目标站立时间返回事件
            //TargetStepsEvent//目标步数返回事件
            //TempEvent//温度数据返回事件
            //TempUniteEvent温度单位事件返回
            //TimerTestHeartRateEvent//定时测量心率事件
            //UserInfoEvent//用户信息返回事件;包含身高体重等信息
            //WatchDeleteEvent//删除表盘事件
            //WatchListEvent//表盘列表事件，用于获取当前手表的表盘列表
            //WatchRemainEvent//剩余空间查询
            //WatchSportsDataEvent//多运动数据返回
            //WatchSwitchEvent//表盘切换事件
            //WatchThemeConfigEvent//表盘信息配置
            //TempCheckHistoryEvent 用户定制历史温度检测返回
            //TempCheckRealEvent 用户定制实时温度检测返回
            //TempCheckTestEvent 用户定制测试温度返回，包含ppg
            EventBusUtils.post(event);
        }).init(this);
    }
}















