package com.qgg.mvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qgg.mvvm.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description：BaseFragment
 *
 * 必须要重写的方法：getLayoutId
 *
 * 可重写如下方法：initData，interceptViewModel，createViewModel，initView
 *
 * @author wangqing
 * @date 2019/12/4
 */
public abstract class BaseFragment<VM extends BaseViewModel, VDB extends ViewDataBinding> extends AssistFragment implements AssistView<VDB> {
    protected VM mViewModel;
    protected VDB mViewDataBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), null, false);
        initViewModel();
        initView();
        initData();
        return mViewDataBinding.getRoot();
    }

    /**
     * 子类可重写，初始化view
     *
     * @param viewDataBinding view binding
     */
    public void initBindingView(VDB viewDataBinding) {
    }

    /**
     * 默认返回false，不拦截BaseFragment创建的ViewModel
     *
     * @return 子类重写返回true表示要拦截，就需要重写setViewModel
     */
    protected boolean interceptViewModel() {
        return false;
    }

    /**
     * 子类重写此方法用于创建ViewModel
     * 默认的ViewModel是来自于fragment，特殊场景可以需要想要使用getActivity来创建ViewModel
     *
     * @return 返回ViewModel
     */
    protected VM createViewModel() {
        return null;
    }

    private void initViewModel() {
        // 子类拦截了，重写createViewModel创建ViewModel
        if (interceptViewModel()) {
            mViewModel = createViewModel();
            return;
        }
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                // 如果没有指定泛型参数，默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
    }


    @Override
    public void showToast(CharSequence text) {
        // TODO 使用工具类去实现
    }

    @Override
    public void showLongToast(CharSequence text) {
        // TODO 使用工具类去实现
    }
}
