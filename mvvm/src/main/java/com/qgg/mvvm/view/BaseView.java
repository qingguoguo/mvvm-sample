package com.qgg.mvvm.view;

import android.databinding.ViewDataBinding;

/**
 * Description：View基类
 *
 * @author wangqing
 * @date 2019/12/4
 */
public interface BaseView<VDB extends ViewDataBinding> {
    /**
     * 子类可重写，初始化view
     *
     * @param viewDataBinding view binding
     */
    void initBindingView(VDB viewDataBinding);
}
