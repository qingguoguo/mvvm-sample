package com.qgg.mvvm.util;

import android.util.Log;

import com.qgg.mvvm.BuildConfig;

/**
 * Description：日志工具类
 *
 * @author wangqing
 * @date 2019/12/4
 */
public class LogUtil {
    private static boolean sLogging;

    private LogUtil() {
    }

    public static void openLog() {
        sLogging = true;
    }

    public static void d(String tag, Object... message) {
        // debug或者设置打印日志将输出日志
        if (sLogging || BuildConfig.DEBUG) {
            Log.d(tag, appendMsg(message));
        }
    }

    private static String appendMsg(Object[] msg) {
        if (msg == null || msg.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : msg) {
            if (object != null) {
                stringBuilder.append(object.toString()).append(" ");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}
