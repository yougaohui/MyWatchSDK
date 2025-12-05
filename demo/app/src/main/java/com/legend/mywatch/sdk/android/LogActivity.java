package com.legend.mywatch.sdk.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.legend.mywatch.sdk.android.event.BytesEvent;
import com.legend.mywatch.sdk.android.utils.EventBusUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LogActivity extends AppCompatActivity {

    private TextView logTextView;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private StringBuilder logBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        logTextView = findViewById(R.id.logTextView);
        EventBusUtils.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBytesEvent(BytesEvent event) {
        String timestamp = String.format("[%tT] ", System.currentTimeMillis());
        String logMessage = timestamp + event.toString() + "\n";
        logBuilder.append(logMessage);

        // Limit the log to a certain number of lines, e.g., 100
        String[] lines = logBuilder.toString().split("\n");
        if (lines.length > 100) {
            logBuilder = new StringBuilder();
            for (int i = lines.length - 100; i < lines.length; i++) {
                logBuilder.append(lines[i]).append("\n");
            }
        }

        logTextView.setText(logBuilder.toString());
        logTextView.post(() -> logTextView.scrollTo(0, logTextView.getBottom()));
    }
}
