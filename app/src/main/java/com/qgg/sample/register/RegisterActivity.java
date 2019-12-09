package com.qgg.sample.register;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.qgg.mvvm.view.BaseActivity;
import com.qgg.sample.R;
import com.qgg.sample.databinding.ActivityRegisterBinding;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ActivityRegisterBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        initFragment();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) {
            fragment = new RegisterFragment();
        }
        fragmentManager.beginTransaction().add(R.id.flContainer, fragment, TAG).commitAllowingStateLoss();
    }
}
