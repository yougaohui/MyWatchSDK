package com.legend.mywatch.sdk.android.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.UriUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.ZipUtils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * 分享工具类
 * Created by gaohui.you on 2019/7/22 0022
 * Email:839939978@qq.com
 */
public class ShareUtils {

    public static void shareImage(Bitmap bitmap) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(Utils.getApp().getContentResolver(), bitmap, "IMG" + Calendar.getInstance().getTime(), null));
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        ActivityUtils.startActivity(Intent.createChooser(intent, "Qrcode"));
    }

    public static void shareFile(File file) {
        shareFiles(CollectionUtils.newArrayList(file));
    }

    public static void shareFiles(List<File> files) {
        try {
            String parentPath = PathUtils.getExternalAppCachePath() + File.separator + "compress";
            FileUtils.createOrExistsDir(parentPath);
            FileUtils.deleteFilesInDir(parentPath);//清除一下缓存
            if (!CollectionUtils.isEmpty(files)) {
                String path = parentPath + File.separator + TimeUtils.getNowMills() + ".zip";
                File distFile = new File(path);
                Intent share = new Intent(Intent.ACTION_SEND);
                ZipUtils.zipFiles(files, distFile);
                Uri contentUri = UriUtils.file2Uri(distFile);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    share.putExtra(Intent.EXTRA_STREAM, contentUri);
                    share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                } else {
                    share.putExtra(Intent.EXTRA_STREAM, contentUri);
                }

                share.setType("application/vnd.ms-excel");//此处可发送多种文件
                share.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                ActivityUtils.startActivity(Intent.createChooser(share, "分享文件"));
            } else {
                ToastUtils.showShort("分享文件不存在");
            }
        } catch (IOException e) {
            ToastUtils.showShort(e.toString());
        }
    }
}
