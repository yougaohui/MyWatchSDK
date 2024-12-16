package com.legend.mywatch.sdk.mywatchsdklib.android.enm;


/**
 * 消息通知类型枚举
 */
public enum NotifyMsgTypeEnm {
    QQ("com.tencent.mobileqq"),//qq消息
    WeChat("com.tencent.mm"), //微信消息
    MMS("app.mms"),  //短信消息
    CALL("com.android.incallui_deldel"),//来电消息
    FACEBOOK("com.facebook.katana"),//faceBook消息
    TWITTER("com.twitter.android"), //TWITTER 消息
    SKYPE("com.skype.raider"),//skype
    LINE("jp.naver.line.android"),//line
    WATSAPP("com.whatsapp"),// WATSAPP
    KAKAOTALK("com.kakao.talk"),//KAKAOTALK
    INSTAGRAM("com.instagram.android"),//INSTAGRAM
    LINKEDIN("com.linkedin.android");//INSTAGRAM

    private String pkgName; //包名

    NotifyMsgTypeEnm(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getPkgName() {
        return pkgName;
    }

}
