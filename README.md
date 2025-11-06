# MyWatchSDK

## 更新说明:

    V1.0.0
    a.首次提交
    
    V1.0.1
    a.修复一些已知bug.
    b.新增温度检测协议.

    V: 1.0.3
    a.修复一些已知bug.
## 1、集成

### （1）方法一本地依赖
        myWatch-release.aar放入lib目录下,并在应用build.gradle下引入. 
### （2）方法二远程依赖
#### a、app下的build.gradle添加
       implementation 'com.github.yougaohui:MyWatchSDK:1.0.3'
#### b、项目下面的build.gradle添加
       repositories {maven { url 'https://jitpack.io' }}
## 2、在Application初始化

    public class App extends Application {
    //TAG
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        WatchSDK.getSDK().setConfig(new Config().setLogListener((tag, log) -> {//sdk日志回调
            Log.i(tag, log);
        })).setOnEventListener(event -> {//设备返回数据事件回调
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
            //SynHisDataEvent//同步历史数据状态事件;包含开始同步历史数据与停止同步历史数据两种状态
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
            //TempCheckHistoryEvent 历史温度检测返回
            //TempCheckRealEvent 实时温度检测返回
        }).init(this);
    }

## 3、接口管理类 SDKCmdManager

    /**
     * 连接设备
     *
     * @param address 设备mac地址
     */
    public static void connectWatch(String address) {
        SDKCmdManager.getCoreService().startConnect(address);
    }

    /**
     * 断开连接
     */
    public static void disconnectWatch() {
        SDKCmdManager.getCoreService().close();
    }

    /**
     * 获取蓝牙核心服务
     *
     * @return
     */
    public static BleCore getCoreService() {
        if (Constant.mService == null) {
            //抛出未初始化SDK异常
            throw new InitSDKException();
        }
        return Constant.mService;
    }

    /**
     * 连接状态
     *
     * @return true = 已连接
     */
    public static boolean isConnected() {
        return Constant.BleState == BluetoothStatusEnum.CONNECTED.getValue();
    }

    /**
     * 找手表
     *
     * @return 发送指令的数据流
     */
    public static byte[] findWatch() {
        return sendCustomOrder(getSetFindMeValue(true), "寻找手环");
    }


    /**
     * 设置语言
     *
     * @param lang 语言枚举
     * @return 发送指令的数据流
     */
    public static byte[] setLanguage(LangEnm lang) {
        return sendCustomOrder(getSetLanguage(lang.getValue()), "设置语言");
    }

    /**
     * 解除绑定
     *
     * @return 发送指令的数据流
     */
    public static byte[] unbindWatch() {
        disconnectWatch();
        MySPUtils.clearSaveKeyValues();
        return sendCustomOrder(getIsBingding(false), "解绑手环");
    }

    /**
     * 重置手环
     *
     * @return 发送指令的数据流
     */
    public static byte[] resetWatch() {
        return sendCustomOrder(getResetDevice(), "重置手环");
    }

    /**
     * 获取目标步数
     *
     * @return 发送指令的数据流
     */
    public static byte[] getTargetSteps() {
        return sendCustomOrder(getSetInfoByKey((byte) 0x02), "获取目标步数");
    }

    /**
     * 获取闹钟列表
     *
     * @return 发送指令的数据流
     */
    public static byte[] getAlarms() {
        return sendCustomOrder(getDeviceSetInfo(1), "读取设备上面的闹铃数据");
    }

    /**
     * 设置闹钟
     * 最多支持8个闹钟
     *
     * @param alarms 闹钟列表
     * @return 发送指令的数据流
     */
    public static byte[] setAlarms(List<Alarm> alarms) {
        return sendCustomOrder(SendData.getSetAlarmValue(alarms), "设置闹铃");
    }

    /**
     * 自定义命令
     *
     * @param val
     * @return 发送指令的数据流
     */
    public static byte[] sendCustomOrder(byte[] val) {
        return sendCustomOrder(val, "自定义命令");
    }

    /**
     * 发送自定义指令
     *
     * @param val         指令字节流
     * @param description 指令描述
     * @return 发送指令的数据流
     */
    public static byte[] sendCustomOrder(byte[] val, String description) {
        if (isConnected()) {
            SDKCmdManager.getCoreService().commandPoolWrite(val, description);
        }
        return val;
    }

    /**
     * 设置抬腕亮屏
     *
     * @param isBright  true 表示开启
     * @param startTime 开始亮屏时间 分钟数：从当天的 0 点算起的分钟数,单位分钟数
     * @param endTime   结束亮屏时间 分钟数：从当天的 0 点算起的分钟数,单位分钟数
     * @return 发送指令的数据流
     */
    public static byte[] setHandLight(boolean isBright, int startTime, int endTime) {
        return sendCustomOrder(SendData.getBrightScreenValue(isBright, startTime, endTime), "设置抬腕亮屏");
    }

    /**
     * 获取翻腕亮屏信息
     *
     * @return 发送指令的数据流
     */
    public static byte[] getInfoOfWristInfo() {
        return sendCustomOrder(getSetInfoByKey((byte) 0x07), "获取翻腕亮屏信息");
    }

    /**
     * 开启拍照功能
     *
     * @return 发送指令的数据流
     */
    public static byte[] openCamera() {
        return sendCustomOrder(getSetCaremaValue(true), "开启拍照功能");
    }

    /**
     * 关闭拍照功能
     *
     * @return 发送指令的数据流
     */
    public static byte[] closeCamera() {
        return sendCustomOrder(getSetCaremaValue(false), "关闭拍照功能");
    }

    /**
     * 设置务扰模式
     *
     * @param isDisturb true 开启，false关闭
     * @param startTime 开始勿扰模式时间 分钟数：从当天的 0 点算起的分钟数 单位分钟
     * @param endTime   结束勿扰模式时间 分钟数：从当天的 0 点算起的分钟数 单位分钟
     */
    public static byte[] setDisturbMode(boolean isDisturb, int startTime, int endTime) {
        return sendCustomOrder(SendData.getDisturbSwitchValue(isDisturb, startTime, endTime), "设置务扰模式");
    }

    /**
     * 获取勿扰模式信息
     *
     * @return 发送指令的数据流
     */
    public static byte[] getDisturbModeInfo() {
        return sendCustomOrder(getSetInfoByKey((byte) 0x09), "获取勿扰模式信息");
    }


    /**
     * 获取久坐提醒
     *
     * @return 发送指令的数据流
     */
    public static byte[] getLongSitWarnInfo() {
        return sendCustomOrder(getSetInfoByKey((byte) 0x03), "获取久坐提醒");
    }


    /**
     * app请求获取天总结实时数据
     *
     * @return 发送指令的数据流
     */
    public static byte[] getTotalSportData() {
        return sendCustomOrder(getSportKeyDayGet(true), "app请求获取天总结实时数据");
    }

    /**
     * 获取个人信息
     *
     * @return 发送指令的数据流
     */
    public static byte[] gtPersonalInfo() {
        return sendCustomOrder(getSetInfoByKey((byte) 0x01), "获取个人信息");
    }

    /**
     * 设置温度单位
     *
     * @param unite 温度单位;0为摄氏，1为华氏
     * @return 发送指令的数据流
     */
    public static byte[] setTempUnite(byte unite) {
        return sendCustomOrder(SendData.getTempUniteValue(new byte[]{unite}), "同步温度单位");
    }

    /**
     * 设置系统时间
     *
     * @return 发送指令的数据流
     */
    public static byte[] synchronTime() {
        return sendCustomOrder(SendData.getSetTimesValue(), "设置系统时间");
    }

    /**
     * 获取表盘升级信息
     *
     * @return 发送指令的数据流
     */
    public static byte[] getClockDialInfo() {
        return sendCustomOrder(SendData.getDialClockInfo(), "获取表盘信息");
    }


    /**
     * 获取表盘列表
     *
     * @return 发送指令的数据流
     */
    public static byte[] getDialWatchList() {
        return sendCustomOrder(SendData.getDialWatchList());
    }

    /**
     * 读取设备表盘剩余空间
     *
     * @return 发送指令的数据流
     */
    public static byte[] readDialWatchRemainSpace() {
        return sendCustomOrder(SendData.getDialWatchRemainSpace());
    }

    /**
     * @return 读取预设表盘列表
     */
    public static byte[] readDialWatchPresetList() {
        return sendCustomOrder(SendData.getDialWatchPresetList());
    }

    /**
     * 读取某个表盘具体参数信息
     *
     * @param watchId 表盘id
     * @return
     */
    public static byte[] readReadWatchThemeDetails(int watchId) {
        return sendCustomOrder(SendData.getReadWatchThemeDetails(watchId));
    }

    /**
     * 设置睡眠提醒信息
     *
     * @param isOpen         睡眠提醒开关，true表示打开
     * @param weeks          index 0~6bit = 周一到周日
     * @param startSleepTime 入睡时间，从0点算起，单位分钟，比如8:00 就是8*60
     * @return 发送指令的数据流
     */
    public static byte[] setSleepWarn(boolean isOpen, byte[] weeks, short startSleepTime) {
        return sendCustomOrder(SendData.getSleepWarnValue(isOpen, NumberUtils.binaryToDecimal(weeks), startSleepTime));
    }

    /**
     * 设置定时测量心率
     *
     * @param min 测量间隔，单位分钟
     * @return 发送指令的数据流
     */
    public static byte[] setHeartTimerValue(short min) {
        return sendCustomOrder(SendData.getHeartTimerValue(min));
    }

    /**
     * 设置喝水提醒
     *
     * @param config
     * @return 发送指令的数据流
     */
    public static byte[] setDrinkWarnValue(DrinkConfigEvent config) {
        return sendCustomOrder(SendData.getDrinkWarnValue(config), "设置喝水提醒");
    }

    /**
     * 设置紧急联系人
     *
     * @param phoneNumber 手机号码
     * @return 发送指令的数据流
     */
    public static byte[] setSOSContract(String phoneNumber) {
        return sendCustomOrder(SendData.getSOSContractValue(ConvertUtils.string2Bytes(phoneNumber)));
    }


    /**
     * 获取关机指令
     *
     * @return 发送指令的数据流
     */
    public static byte[] shutdown() {
        return sendCustomOrder(SendData.getShutdownCmd());
    }

    /**
     * 游戏开始
     *
     * @return 发送指令的数据流
     */
    public static byte[] gameOfBegin() {
        return sendCustomOrder(SendData.getGameOfBegin());
    }

    /**
     * 游戏退出
     *
     * @return 发送指令的数据流
     */
    public static byte[] gameOfExit() {
        return sendCustomOrder(SendData.getGameOfExit());
    }


    /**
     * 设置手势控制开关配置
     *
     * @param configModel 手势控制开关配置信息
     * @return 发送指令的数据流
     */
    //getGestureControlValue
    public static byte[] setGestureControl(GestureControlConfigEvent configModel) {
        return sendCustomOrder(SendData.getGestureControlValue(configModel));
    }

    /**
     * 设置imei
     *
     * @param imei imei
     * @return 发送指令的数据流
     */
    //getImeiBytes
    public static byte[] setImei(String imei) {
        return sendCustomOrder(SendData.getImeiBytes(imei));
    }

    /**
     * 设置付款码
     *
     * @param payWay 支付方式,0微信支付.1支付宝支付,2核酸码
     * @param url    支付码url utf-8
     * @return 发送指令的数据流
     */
    public static byte[] setPayQrCode(byte payWay, String url) {
        return sendCustomOrder(SendData.getPayValue(payWay, url));
    }


    /**
     * 设置收款码
     *
     * @param shopNo 商户NO
     * @param qrcode 二维码内容，utf-8
     * @return 发送指令的数据流
     */
    public static byte[] sendPaymentCode(String shopNo, String qrcode) {
        byte[] shopNoBytes = ConvertUtils.string2Bytes(shopNo);
        short shopNoLen = (short) shopNoBytes.length;
        byte[] shopLengthBytes = ByteUtil.shortToByte(shopNoLen);

        byte[] qrcodeBytes = ConvertUtils.string2Bytes(qrcode);
        short qrcodeLen = (short) qrcodeBytes.length;
        byte[] qrcodeLengthBytes = ByteUtil.shortToByte(qrcodeLen);

        byte[] payload = NumberUtils.combineBytes(shopLengthBytes, shopNoBytes, qrcodeLengthBytes, qrcodeBytes);

        return sendCustomOrder(SendData.getPayValueBytes((byte) 3, payload), "同步收款码");
    }


    /**
     * 设置目标步数协议
     *
     * @param targetStep
     * @return 发送指令的数据流
     */
    public static byte[] setTargetStep(int targetStep) {
        return sendCustomOrder(SendData.getSetStepValue(targetStep), "设置目标步数");
    }

    /**
     * 设置目标运动时间
     *
     * @param targetSPortTime 单位分钟
     * @return 发送指令的数据流
     */
    public static byte[] setTargetSportTime(short targetSPortTime) {
        return sendCustomOrder(SendData.getSetSportTimeValue(targetSPortTime), "设置目标运动时间");
    }

    /**
     * 设置目标站立时间
     *
     * @param standHour 单位小时
     * @return 发送指令的数据流
     */
    public static byte[] setStandTime(byte standHour) {
        return sendCustomOrder(SendData.getSetStandTimeValue(standHour), "设置目标站立时间");
    }

    /**
     * 设置目标卡路里
     *
     * @param targetCal 单位大卡
     * @return 发送指令的数据流
     */
    public static byte[] setTargetCalValue(short targetCal) {
        return sendCustomOrder(SendData.getTargetCalValue(targetCal), "设置目标卡路里");
    }

    /**
     * 设置用户个人信息
     *
     * @param gender       1 表示男性，0表示女性
     * @param age          年龄
     * @param height       身高 cm
     * @param weight       体重 kg
     * @param distanceUnit 距离单位 1表示公里, 2表示英里
     * @return 发送指令的数据流
     */
    public static byte[] setUInfoValue(int gender, int age, int height, int weight, int distanceUnit) {
        return sendCustomOrder(SendData.getSetUinfoValue(gender, age, height, weight, distanceUnit), "设置用户个人信息");
    }

    /**
     * 设置久坐提醒协议
     *
     * @param isOpen      true 表示打开
     * @param sitDuration 久坐时间15 分钟为单位， 最长为 2 小时，久坐超过这个时间，则提醒。比如 sitDuration = 4,则久坐时长为15x4=60分钟
     * @param startTime   久坐开提醒时间 以小时为单位 ， 范围0~23
     * @param endTime     久坐结束提醒时间 以小时为单位 ， 范 围0~23
     * @return 发送指令的数据流
     */
    public static byte[] setLongSitValue(boolean isOpen, int sitDuration, int startTime, int endTime) {
        return sendCustomOrder(SendData.getSetLongSitValue(isOpen, sitDuration, startTime, endTime), "设置用户个人信息");
    }


    /**
     * 设置左右手佩戴协议
     *
     * @param HandState 左右手佩 1右手，0左手
     * @return 发送指令的数据流
     */
    public static byte[] setSetHandSideValue(int HandState) {
        return sendCustomOrder(SendData.getSetHandSideValue(HandState), "设置左右手佩戴");
    }

    /**
     * 设置震动开关
     *
     * @param isShock 马达开关 true 开启
     * @return 发送指令的数据流
     */
    public static byte[] setSetShock(boolean isShock) {
        return sendCustomOrder(SendData.getSetWatchRemindValue(false, isShock, false, false), "设置马达开关");
    }

    /**
     * 设置消息推送开关（来电、短信、微信、QQ）协议
     *
     * @param messageStatus 消息开关配置
     * @return 发送指令的数据流
     */
    public static byte[] setCallRemindValue(MessageStatusEvent messageStatus) {
        return sendCustomOrder(SendData.getSetCallRemindValue(messageStatus), "设置马达开关");
    }


    /**
     * 发送消息推送
     *
     * @param type     消息类型
     * @param msg      消息内容
     * @param callType 来电提醒类型,仅来电使用
     * @return byte[] 可能为null，表示发送给的数据为空
     */
    public static byte[] sendNotifyPush(NotifyMsgTypeEnm type, String msg, CallStatusEnm callType) {
        return NotifyMsgHelper.sendNotifyPush(type, msg, callType.getValue());
    }

    public static byte[] sendNotifyPush(NotifyMsgTypeEnm type, String msg) {
        return NotifyMsgHelper.sendNotifyPush(type, msg, CallStatusEnm.CALL_STATE_DEFAULT.getValue());
    }

    /**
     * 同步联系人
     *
     * @param contracts 格式:联系人姓名_联系人手机号
     * @return 发送指令的数据流
     */
    public static byte[] synContract(String contracts) {
        return sendCustomOrder(SendData.getSynContractValue(ConvertUtils.string2Bytes(contracts)), "同步联系人");
    }

    /**
     * 删除联系人
     *
     * @param phoneNumber 电话号码
     * @return 发送指令的数据流
     */
    public static byte[] deleteContract(String phoneNumber) {
        byte CommandKey = Profile.PBSmartBandCommandIdSettingKeyId.PBSmartBandCommandIdSettingKeyDelteContract;
        return sendCustomOrder(SendData.getDeleteContractValue(ConvertUtils.string2Bytes(phoneNumber)));
    }

    /**
     * 同步天气
     *
     * @param weatherModel 天气信息
     * @param symbol       温度单位;0为摄氏，1为华氏
     * @return 发送指令的数据流
     */
    public static byte[] syncWeatherInfo(WeatherModel weatherModel, int symbol) {
        return WeatherProxy.syncWeatherInfo(weatherModel, symbol);
    }

    /**
     * 测试心率
     *
     * @param enable true 表示开始测量心率，false停止
     * @return 发送指令的数据流
     */
    public static byte[] testHeartRate(boolean enable) {
        return sendCustomOrder(SendData.getSportMeasureHeartRecive(enable), "测试心率:" + enable);
    }

    /**
     * 测试血压
     *
     * @param enable true 表示开始测量，false停止
     * @return 发送指令的数据流
     */
    public static byte[] testBloodPressure(boolean enable) {
        return sendCustomOrder(SendData.getSportMeasureBloodRecive(enable), "测试血压");
    }

    /**
     * 测试血氧
     *
     * @param enable true 表示开始测量，false停止
     * @return 发送指令的数据流
     */
    public static byte[] testBloodOxygen(boolean enable) {
        return sendCustomOrder(SendData.getSportMeasureSpoRecive(enable), "测试血氧");
    }

    /**
     * 测试心电
     *
     * @param enable true 表示开始测量，false停止
     * @return 发送指令的数据流
     */
    public static byte[] testECG(boolean enable) {
        return sendCustomOrder(SendData.getSportECGRecive(enable), "测试心电");
    }

    /**
     * 设置APP进入前台状态
     *
     * @param isForeground true APP表示进入前台；false表示进入后台
     * @return 发送指令的数据流
     */
    public static byte[] setForegroundSwitch(boolean isForeground) {
        return sendCustomOrder(SendData.getTurnOnRealTimeStep(isForeground), "进入前台:" + isForeground);
    }

    /**
     * 配对指令
     *
     * @return 发送指令的数据流
     */
    public static byte[] pair() {
        return sendCustomOrder(SendData.getPair(), "配对");
    }

    /**
     * 删除表盘
     *
     * @param watchId 表盘id
     * @return 发送指令的数据流
     */
    public static byte[] deleteWatch(int watchId) {
        return sendCustomOrder(SendData.getDialUpdateDeleteValue(watchId), "删除表盘");
    }

    /**
     * 切换表盘
     *
     * @param watchId 表盘id
     * @return 发送指令的数据流
     */
    public static byte[] switchWatch(int watchId) {
        return sendCustomOrder(SendData.getDialUpdateSwitchValue(watchId), "切换表盘");
    }

    /**
     * 读取软件版本号
     */
    public static void readWatchVersion() {
        if (isConnected()) {
            SDKCmdManager.getCoreService().readSoftVersion();
        }
    }

    /**
     * 读取设备特征
     */
    public static void readDeviceFeature() {
        if (isConnected()) {
            SDKCmdManager.getCoreService().readDeviceFeature();
        }
    }

    /**
     * 读取自定义功能
     */
    public static void readCustomFunction() {
        if (isConnected()) {
            SDKCmdManager.getCoreService().readCustomFunction();
        }
    }

## 4、连接

    SDKCmdManager.connectWatch(address);

## 5、关于本地通信指令解释 Profile,通过AckEvent中的getMsgWhat()获取，和 Profile.MsgWhat进行对比

        public static final int what10 = 10; // 解绑手环
        public static final int what11 = 11; // 接收历史数据中
        public static final int what12 = 12; // 接收历史数据完成
        public static final int what13 = 13; // 重置
        public static final int what14 = 14; // 请求设置信息(取代 0x09 命令，具体 key 参考后面)
        public static final int what2 = 2121; // 蓝牙状态
        public static final int what30 = 30; // 蓝牙初始设置显示 时间
        public static final int what31 = 31; // 蓝牙初始设置显示 个人信息
        public static final int what32 = 32; // 蓝牙初始设置显示 目标步数
        public static final int what33 = 33; //设置消息推送开关（来电、短信、微信、QQ）
        public static final int what34 = 34; //闹铃列表
        public static final int what35 = 35; //设置闹铃
        public static final int what36 = 36; //设置久坐提醒
        public static final int what37 = 37; // 安卓手机来电推送（来电、挂断电话、电话号码和姓名）安卓手机消息推销（来电、短信、微信、QQ）
        public static final int what38 = 38; //语言设置（value：中文：0x00 英文：0x01）
        public static final int what39 = 39; //抬腕亮屏设置
        public static final int what300 = 300; //勿扰模式
        public static final int what301 = 301; //睡眠开关设置和睡眠有效时间段设置
        public static final int what302 = 302; //心率自动测量
        public static final int what40 = 40; //左右手设置
        public static final int what5 = 5; // 蓝牙运动实时步数
        public static final int what64 = 64; //测量心率开始/关闭(APP发起)
        public static final int what65 = 65; //测量血压开始/关闭(APP发起)
        public static final int what68 = 68; //测量血氧开始/关闭(APP发起)
        public static final int what19 = 19;//添加联系人
        public static final int what23 = 23;//删除联系人
        public static final int what24 = 24;//设置紧急联系人
        public static final int what25 = 25;//同步温度单位
        public static final int what91 = 91; // 设置目标锻炼时间
        public static final int what92 = 92; // 设置目标站立目标
        public static final int what93 = 93; // 睡眠提醒
        public static final int what94 = 94; // 定时测量心率
        public static final int what97 = 97; // 设置目标卡路里
        public static final int what98 = 98; // 饮水提醒
        public static final int what99 = 99; // 手势控制
        public static final int what100 = 100; // imei号
        public static final int what101 = 101; // OTA升级模块个数

## 6、关于蓝牙扫描注意事项

###  

    Android12及以上需要动态申请Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_ADVERTISE权限

## 7、数据发送

### SDKCmdManager

    SDKCmdManager 封装了常用的指令发送接口，直接调用就可以。

## 8、数据接收

    WatchSDK.getSDK().setOnEventListener设置监听器监听，具体请参考初始化

## 9、语言设置

    使用LangEnm枚举
    lang对应国家的编码:
    简体中文：0x00 英文：0x01 繁体：0x02 阿拉伯语：x03 捷克语：0x04 德语:0x05  西班牙语:0x06  法语:0x07  日语:0x08  马来西亚语:0x09  荷兰语:0xA  波兰语:0xB  葡萄牙语:0xC  俄语:0xD  斯洛伐克语:0xE  泰语:0xF  土耳其语:0x10 越南语:0x11 意大利语:0x12 菲律宾语:0x13 印尼语:0x14
    乌克兰语:0x15 印度语:0x16 芬兰语:0x17 克罗地亚语:0x18 挪威语:0x19  丹麦语:0x1A 瑞典语:0x1B  韩语:0x1C 匈牙利语:0x1D 希腊语:0x1E 波斯语:0x1F 罗马尼亚语:0x20  缅甸语:0x21  孟加拉语：0x22

## 10、关于AckEvent说明

### （1）、解释

    发送任意给手环的合法指令，都会返回对应的AckEvent,用于确认指令是否达到设备或者确认设备是否处理成功这条指令。
    例如设置闹钟，发送成功闹钟参数，就会返回对应的ack

### （2）、getMsgWhat()

      返回当前ack类型,仅对部分ack进行封装，返回0表示未知类型，其他类型对应Profile.MsgWhat

### （3）、isCurrentAck（commandValue）（建议使用，比较灵活）

     解释:这个方法也可以判断当前ack属于哪条指令，需要传入发送的指令数据（commandValue发送给设备的原始数据），
     在sdk没有封装类型的时候可以用这个方法

## 11、表盘升级错误码

    public static final int ERROR_UPDATING = 1000;//正在更新
    public static final int ERROR_WAIT_TIMEOUT = 1001;//等待设备返回数据超时
    public static final int ERROR_RESEND_TIMEOUT = 1002;//重发等待设备返回数据超时
    public static final int ERROR_CHECK = 1003;//校验错误，设备端返回的
    public static final int ERROR_IMG_FILE_NO_EXIST = 1004;//图片固件文件不存在
    public static final int ERROR_FONT_FILE_NO_EXIST = 1005;//字体固件文件不存在
    public static final int ERROR_BLE_DISCONNECTED = 1006;//app和设备已断开
    public static final int ERROR_UNKNOWN = 1007;//未知错误，设备端返回0过来导致的
    public static final int ERROR_BATTERY_LOW = 1008;//电量低
    public static final int ERROR_CHARGE_BATTERY = 1009;//正在充电
    public static final int ERROR_MEMORY_LESS = 1010;//空间不足
    public static final int ERROR_WATCH_NUMBER_MAX = 1011;//表盘已经超过上限
    public static final int ERROR_WATCH_UNIQUE = 1012;//不能重复升级
    public static final int ERROR_WATCH_NOT_FOUND_WATCH_ID = 1013;//没有发现表盘ID
    public static final int ERROR_WATCH_STOP_WATCH_UPDATE = 1014;//停止表盘升级
    public static final int ERROR_WATCH_IS_FAST = 1015;//升级过于频繁，请稍后再试

## 12、[枚举解释](./doc/enm)
## 13、[事件解释](./doc/event)
## 13、[model解释](./doc/model)
## 14、关于蓝牙扫描注意事项
###  (1)、SDK没有开放给用户扫描蓝牙的接口，不建议用sdk扫描方法。
###  (2)、推荐使用[nrf](https://github.com/NordicSemiconductor/Android-Scanner-Compat-Library)的扫描
        implementation 'no.nordicsemi.android.support.v18:scanner:1.6.0'
###  (3)、权限注意事项
      Android 7 到Android11 需要打开定位并获取定位权限才能扫描到设备。
      Android12及以上需要动态申请Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_ADVERTISE权限。
###  (4)、项目demo有扫描的示例代码;[ScanActivity](./demo/app/src/main/java/com/legend/mywatch/sdk/android/scan/ScanActivity.java)
## 15、[多运动不同运动模式解释](./doc/constant/SportsConstant.java)