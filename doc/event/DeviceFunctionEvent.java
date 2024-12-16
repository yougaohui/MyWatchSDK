package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 自定义功能事件;用于区分不同设备支持不同功能使用
 */
public class DeviceFunctionEvent extends BaseEvent{
    boolean isShowOta;//是否支持OTA
    boolean isShowBattery;//是否支持电量
    boolean isShowHeart;//是否支持心率
    boolean isShowBlood;//是否支持血压
    boolean isShowSpo;//是否支持血氧
    boolean isShowSleep;//是否支持睡眠
    boolean isShowDistance;//是否支持长度单位
    boolean isShowWxsport;//是否支持微信运动
    boolean isShowVoice;//是否支持语音通话
    boolean isDefaultOpenCall;//是否默认开启来电推送
    boolean isShowSyncontract;//是否有同步联系人功能
    boolean isShowTemp;//是否支持温感
    boolean isShowWeather;//是否支持多天气
    boolean isShowClockDial;//是否支持表盘
    boolean isShowMoreNotifi;//是否支持更多通知
    boolean isShowAdv;//是否展示广告
    boolean isShowRemoteCamera;//是否支持远程拍照
    boolean isShowFindDevice;//是否支持找设备
    boolean isShowHrEl;//是否支持心电
    boolean isShowLongDurationTime;//是否显示久坐时长
    boolean isShowDisturbMode;//是否支持勿扰模式
    boolean isShowShakeMode;//是否支持震动模式
    boolean isCloseTempUnite;//是否关闭温度单位
    boolean isCloseDrinkWarn;//是否关闭喝水提醒
    boolean isTurnOff;//是否支持关机
    boolean isCloseNotification;//是否关闭消息推送
    boolean isSupportOfBodyGame;//是否支持体感游戏
    boolean isSupportOfGestureControl;//是否支持手势控制
    boolean isSupportOfIMEI;//是否支持显示imei号
    boolean isSupportOfExercise;//是否支持显示锻炼
    boolean isSupportOfArmRemoval;//是否支持脱腕


    public boolean isShowOta() {
        return isShowOta;
    }

    public void setShowOta(boolean showOta) {
        isShowOta = showOta;
    }

    public boolean isShowBattery() {
        return isShowBattery;
    }

    public void setShowBattery(boolean showBattery) {
        isShowBattery = showBattery;
    }

    public boolean isShowHeart() {
        return isShowHeart;
    }

    public void setShowHeart(boolean showHeart) {
        isShowHeart = showHeart;
    }

    public boolean isShowBlood() {
        return isShowBlood;
    }

    public void setShowBlood(boolean showBlood) {
        isShowBlood = showBlood;
    }

    public boolean isShowSpo() {
        return isShowSpo;
    }

    public void setShowSpo(boolean showSpo) {
        isShowSpo = showSpo;
    }

    public boolean isShowSleep() {
        return isShowSleep;
    }

    public void setShowSleep(boolean showSleep) {
        isShowSleep = showSleep;
    }

    public boolean isShowDistance() {
        return isShowDistance;
    }

    public void setShowDistance(boolean showDistance) {
        isShowDistance = showDistance;
    }

    public boolean isShowWxsport() {
        return isShowWxsport;
    }

    public void setShowWxsport(boolean showWxsport) {
        isShowWxsport = showWxsport;
    }

    public boolean isShowVoice() {
        return isShowVoice;
    }

    public void setShowVoice(boolean showVoice) {
        isShowVoice = showVoice;
    }

    public boolean isDefaultOpenCall() {
        return isDefaultOpenCall;
    }

    public void setDefaultOpenCall(boolean defaultOpenCall) {
        isDefaultOpenCall = defaultOpenCall;
    }

    public boolean isShowSyncontract() {
        return isShowSyncontract;
    }

    public void setShowSyncontract(boolean showSyncontract) {
        isShowSyncontract = showSyncontract;
    }

    public boolean isShowTemp() {
        return isShowTemp;
    }

    public void setShowTemp(boolean showTemp) {
        isShowTemp = showTemp;
    }

    public boolean isShowWeather() {
        return isShowWeather;
    }

    public void setShowWeather(boolean showWeather) {
        isShowWeather = showWeather;
    }

    public boolean isShowClockDial() {
        return isShowClockDial;
    }

    public void setShowClockDial(boolean showClockDial) {
        isShowClockDial = showClockDial;
    }

    public boolean isShowMoreNotifi() {
        return isShowMoreNotifi;
    }

    public void setShowMoreNotifi(boolean showMoreNotifi) {
        isShowMoreNotifi = showMoreNotifi;
    }

    public boolean isShowAdv() {
        return isShowAdv;
    }

    public void setShowAdv(boolean showAdv) {
        isShowAdv = showAdv;
    }

    public boolean isShowRemoteCamera() {
        return isShowRemoteCamera;
    }

    public void setShowRemoteCamera(boolean showRemoteCamera) {
        isShowRemoteCamera = showRemoteCamera;
    }

    public boolean isShowFindDevice() {
        return isShowFindDevice;
    }

    public void setShowFindDevice(boolean showFindDevice) {
        isShowFindDevice = showFindDevice;
    }

    public boolean isShowHrEl() {
        return isShowHrEl;
    }

    public void setShowHrEl(boolean showHrEl) {
        isShowHrEl = showHrEl;
    }

    public boolean isShowLongDurationTime() {
        return isShowLongDurationTime;
    }

    public void setShowLongDurationTime(boolean showLongDurationTime) {
        isShowLongDurationTime = showLongDurationTime;
    }

    public boolean isShowDisturbMode() {
        return isShowDisturbMode;
    }

    public void setShowDisturbMode(boolean showDisturbMode) {
        isShowDisturbMode = showDisturbMode;
    }

    public boolean isShowShakeMode() {
        return isShowShakeMode;
    }

    public void setShowShakeMode(boolean showShakeMode) {
        isShowShakeMode = showShakeMode;
    }

    public boolean isCloseTempUnite() {
        return isCloseTempUnite;
    }

    public void setCloseTempUnite(boolean closeTempUnite) {
        isCloseTempUnite = closeTempUnite;
    }

    public boolean isCloseDrinkWarn() {
        return isCloseDrinkWarn;
    }

    public void setCloseDrinkWarn(boolean closeDrinkWarn) {
        isCloseDrinkWarn = closeDrinkWarn;
    }

    public boolean isTurnOff() {
        return isTurnOff;
    }

    public void setTurnOff(boolean turnOff) {
        isTurnOff = turnOff;
    }

    public boolean isCloseNotification() {
        return isCloseNotification;
    }

    public void setCloseNotification(boolean closeNotification) {
        isCloseNotification = closeNotification;
    }

    public boolean isSupportOfBodyGame() {
        return isSupportOfBodyGame;
    }

    public void setSupportOfBodyGame(boolean supportOfBodyGame) {
        isSupportOfBodyGame = supportOfBodyGame;
    }

    public boolean isSupportOfGestureControl() {
        return isSupportOfGestureControl;
    }

    public void setSupportOfGestureControl(boolean supportOfGestureControl) {
        isSupportOfGestureControl = supportOfGestureControl;
    }

    public boolean isSupportOfIMEI() {
        return isSupportOfIMEI;
    }

    public void setSupportOfIMEI(boolean supportOfIMEI) {
        isSupportOfIMEI = supportOfIMEI;
    }

    public boolean isSupportOfExercise() {
        return isSupportOfExercise;
    }

    public void setSupportOfExercise(boolean supportOfExercise) {
        isSupportOfExercise = supportOfExercise;
    }

    public boolean isSupportOfArmRemoval() {
        return isSupportOfArmRemoval;
    }

    public void setSupportOfArmRemoval(boolean supportOfArmRemoval) {
        isSupportOfArmRemoval = supportOfArmRemoval;
    }
}
