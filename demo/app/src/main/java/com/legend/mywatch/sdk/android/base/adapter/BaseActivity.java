package com.legend.mywatch.sdk.android.base.adapter;

import androidx.appcompat.app.AppCompatActivity;

import com.legend.mywatch.sdk.android.utils.EventBusUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends AppCompatActivity {
    //TAG
    public static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onResume() {
        super.onResume();
        EventBusUtils.register(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        EventBusUtils.unregister(this);
    }


    /**
     * 事件广播入口
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Object event) {/* Do something */}

}
