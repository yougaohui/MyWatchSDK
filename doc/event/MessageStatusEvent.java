package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 消息提醒开关状态返回事件
 */
public class MessageStatusEvent extends BaseEvent {
    private boolean isCall; //来电提醒 1开启，0关闭
    private boolean isSMS;//短信推送 1开启，0关闭
    private boolean isWechat;//微信推送 1开启，0关闭
    private boolean isQQ;//QQ信息推送 1开启，0关闭
    private boolean isFacebook;//FaceBook推送 1开启，0关闭
    private boolean isTwitter;//Twitter推送  1开启，0关闭
    private boolean isSkype;//Skype推送 1开启，0关闭
    private boolean isLine;//Line推送 1开启，0关闭
    private boolean isWhatsApp;//WhatsApp推送 1开启，0关闭
    private boolean isKakaoTalk;//KakaoTalk推送 1开启，0关闭
    private boolean isInstagram;//Instagram推送 1开启，0关闭
    private boolean isLinkedLineState;//LinkedLine 1开启，0关闭

    public boolean isCall() {
        return isCall;
    }

    public void setCall(boolean call) {
        isCall = call;
    }

    public boolean isSMS() {
        return isSMS;
    }

    public void setSMS(boolean SMS) {
        isSMS = SMS;
    }

    public boolean isWechat() {
        return isWechat;
    }

    public void setWechat(boolean wechat) {
        isWechat = wechat;
    }

    public boolean isQQ() {
        return isQQ;
    }

    public void setQQ(boolean QQ) {
        isQQ = QQ;
    }

    public boolean isFacebook() {
        return isFacebook;
    }

    public void setFacebook(boolean facebook) {
        isFacebook = facebook;
    }

    public boolean isTwitter() {
        return isTwitter;
    }

    public void setTwitter(boolean twitter) {
        isTwitter = twitter;
    }

    public boolean isSkype() {
        return isSkype;
    }

    public void setSkype(boolean skype) {
        isSkype = skype;
    }

    public boolean isLine() {
        return isLine;
    }

    public void setLine(boolean line) {
        isLine = line;
    }

    public boolean isWhatsApp() {
        return isWhatsApp;
    }

    public void setWhatsApp(boolean whatsApp) {
        isWhatsApp = whatsApp;
    }

    public boolean isKakaoTalk() {
        return isKakaoTalk;
    }

    public void setKakaoTalk(boolean kakaoTalk) {
        isKakaoTalk = kakaoTalk;
    }

    public boolean isInstagram() {
        return isInstagram;
    }

    public void setInstagram(boolean instagram) {
        isInstagram = instagram;
    }

    public boolean isLinkedLineState() {
        return isLinkedLineState;
    }

    public void setLinkedLineState(boolean linkedLineState) {
        isLinkedLineState = linkedLineState;
    }
}
