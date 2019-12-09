package com.qgg.mvvm.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qgg.mvvm.util.LogUtil;

/**
 * Description:预留中间层
 *
 * @author wangqing
 * @date 2019/12/11
 */
public abstract class AssistFragment extends Fragment {
    protected final String TAG = getClass().getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, "onCreate", this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.d(TAG, "onCreateView", this);
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.d(TAG, "onActivityCreated", this);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d(TAG, "onResume", this);
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.d(TAG, "onPause", this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d(TAG, "onDestroyView", this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, "onDestroy", this);
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
}
