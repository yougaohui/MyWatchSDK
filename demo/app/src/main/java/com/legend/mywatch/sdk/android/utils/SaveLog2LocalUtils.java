package com.legend.mywatch.sdk.android.utils;

import android.os.Build;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RomUtils;
import com.blankj.utilcode.util.TimeUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class SaveLog2LocalUtils {
    public static final String CACHE_PATH =  LogUtils.getConfig().getDir();
    private static final String DEFAULT_NAME = "log";
    private static final String DEFAULT_PATH = CACHE_PATH + DEFAULT_NAME;
    public static final String CONNECT_NAME = "connect";//连接日志
    //默认文件后缀
    private static final String DEFAULT_SUFFIX = ".txt";

    public static void saveLog(String log) {
        saveLog(DEFAULT_NAME, log);
    }

    public static void saveLog(String name, String log) {
        saveLog(name, log, DEFAULT_SUFFIX);
    }

    public static void saveLog(String name, String log, String suffix) {
        saveLog(name, log, false, suffix);
    }

    public static void saveLog(String name, String log, boolean isAppendDate, String suffix) {
        if (isAppendDate) {
            name = name + "_" + TimeUtils.getNowString(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH));
        }
        writeLog(log, CACHE_PATH + name, suffix);
    }

    public static void writeLog(String log) {
        writeLog(log, DEFAULT_PATH, DEFAULT_SUFFIX);
    }

    public static void writeLog(String log, final String path1, String suffix) {
        new Thread(() -> {
            String path = path1 + suffix;
            //写log
            FileIOUtils.writeFileFromString(path, TimeUtils.getNowString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH)) + " " + log + "\n", true);
            //检测path路径下的.txt文件是否大于N行，如果大于1M就依次删除前面N行的数据
            File file = new File(path);
            List<String> lines = FileIOUtils.readFile2List(file);
            int lineCount = CollectionUtils.size(lines);
            int maxLine = 10000;
            if (lineCount > maxLine) {
                int delCount = (lineCount - maxLine) + 3000;
                lines = lines.subList(delCount, lineCount);
                //lines转换成字符串
                StringBuilder newContent = new StringBuilder();
                for (String line : lines) {
                    newContent.append(line).append("\n");
                }

                //覆盖原来的log
                FileIOUtils.writeFileFromString(path, newContent.toString(), false);
            }
        }).start();
    }


    public static String getPathByName(String name) {
        return getPathByName(name, DEFAULT_SUFFIX);
    }

    public static String getPathByName(String name, String suffix) {
        return CACHE_PATH + name + suffix;
    }

    /**
     * 缓存连接log
     *
     * @param log
     */
    public static void saveConnectLog(String log) {
        saveLog(SaveLog2LocalUtils.CONNECT_NAME, log);
    }

    //获取DEFAULT_PATH
    public static String getDefaultPath() {
        return CACHE_PATH;
    }

    public static String getHeadInfo() {
        StringBuilder sb = new StringBuilder();
        String border = "************* Head ****************\n";
        sb.append(border);
        sb.append("Rom Info           : ").append(RomUtils.getRomInfo()).append("\n");
        sb.append("Device Manufacturer: ").append(Build.MANUFACTURER).append("\n");
        sb.append("Device Model       : ").append(Build.MODEL).append("\n");
        sb.append("Android Version    : ").append(Build.VERSION.RELEASE).append("\n");
        sb.append("Android SDK        : ").append(Build.VERSION.SDK_INT).append("\n");
        sb.append("App VersionName    : ").append(AppUtils.getAppVersionName()).append("\n");
        sb.append("App VersionCode    : ").append(AppUtils.getAppVersionCode()).append("\n");
        return sb.append(border).append("\n").toString();
    }

}
