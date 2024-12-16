package com.legend.mywatch.sdk.mywatchsdklib.android.event;


/**
 * @author yougaohui
 * @email 839939978@qq.com
 * @desciption 手势控制开关配置信息
 * @since 2024/7/3 16:26
 **/
public class GestureControlConfigEvent extends BaseEvent{
    private boolean isEnableOfGestureAnswer; //手势接听
    private boolean isEnableOfGestureRejection; //手势拒接
    private boolean isEnableOfGestureVideo; //手势视频切换
    private boolean isEnableOfGestureMusic; //手势音乐切换


    public boolean isEnableOfGestureAnswer() {
        return isEnableOfGestureAnswer;
    }

    public void setEnableOfGestureAnswer(boolean enableOfGestureAnswer) {
        isEnableOfGestureAnswer = enableOfGestureAnswer;
    }

    public boolean isEnableOfGestureRejection() {
        return isEnableOfGestureRejection;
    }

    public void setEnableOfGestureRejection(boolean enableOfGestureRejection) {
        isEnableOfGestureRejection = enableOfGestureRejection;
    }

    public boolean isEnableOfGestureVideo() {
        return isEnableOfGestureVideo;
    }

    public void setEnableOfGestureVideo(boolean enableOfGestureVideo) {
        isEnableOfGestureVideo = enableOfGestureVideo;
    }

    public boolean isEnableOfGestureMusic() {
        return isEnableOfGestureMusic;
    }

    public void setEnableOfGestureMusic(boolean enableOfGestureMusic) {
        isEnableOfGestureMusic = enableOfGestureMusic;
    }
}
