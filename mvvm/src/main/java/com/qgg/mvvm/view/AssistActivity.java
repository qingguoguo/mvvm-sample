package com.qgg.mvvm.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.qgg.mvvm.util.LogUtil;

/**
 * Description: 预留中间层
 *
 * @author wangqing
 * @date 2019/12/11
 */
public abstract class AssistActivity extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, "onCreate", this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, "onResume", this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG, "onPause", this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, "onDestroy", this);
    }

    @Override
    public void finish() {
        super.finish();
        LogUtil.d(TAG, "finish", this);
    }

    /**
     * 子类重写返回LayoutId
     *
     * @return layoutId
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 子类可重写，初始化数据
     */
    protected void initData() {
    }

    /**
     * 子类可重写，初始化View
     */
    protected void initView() {
    }

    /**
     * 解析Intent传递的数据
     *
     * @param intent 返回intent
     */
    protected void parseIntent(@NonNull Intent intent) {
    }
}
