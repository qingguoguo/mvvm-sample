package com.qgg.sample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Description：Application基类
 *
 * @author wangqing
 * @date 2019/12/9
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLeakCanary();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
