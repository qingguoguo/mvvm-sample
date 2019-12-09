package com.qgg.sample.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.qgg.mvvm.util.LogUtil;

/**
 * Description：测试 Lifecycle生命周期
 *
 * @author wangqing
 * @date 2019/12/10 on 10:29
 */
public class MainPresenter implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(LifecycleOwner owner) {
        LogUtil.d("MainPresenter", "onCreate", this.getClass().toString());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        LogUtil.d("MainPresenter", "onDestroy", this.getClass().toString());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event) {
    }
}
