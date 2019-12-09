package com.qgg.sample;

import android.view.View;

import com.qgg.mvvm.view.BaseActivity;
import com.qgg.sample.databinding.MainActivityBinding;
import com.qgg.sample.lifecycle.MainPresenter;

public class MainActivity extends BaseActivity<MainViewModel, MainActivityBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    protected void initData() {
        getLifecycle().addObserver(new MainPresenter());
    }

    public void startLoginActivity(View view) {
        mViewModel.startLoginActivity(this);
    }

    public void startRegisterActivity(View view) {
        mViewModel.startRegisterActivity(this);
    }

    public void startCalculatorActivity(View view) {
        mViewModel.startCalculatorActivity(this);
    }
}
