package com.qgg.mvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.qgg.mvvm.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description：BaseActivity
 *
 * 必须要重写的方法：getLayoutId
 *
 * 可重写如下方法：parseIntent，initData，initView
 *
 * @author wangqing
 * @date 2019/12/4
 */
public abstract class BaseActivity<VM extends BaseViewModel, VDB extends ViewDataBinding> extends AssistActivity implements AssistView<VDB> {
    protected VM mViewModel;
    protected VDB mViewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parseIntent();
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        createViewModel();
        initView();
        initData();
    }

    private void parseIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            parseIntent(intent);
        }
    }

    /**
     * 子类可重写，初始化view
     *
     * @param viewDataBinding view binding
     */
    public void initBindingView(VDB viewDataBinding) {
    }

    private void createViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                // 没有指定泛型参数，默认使用BaseViewModel
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

