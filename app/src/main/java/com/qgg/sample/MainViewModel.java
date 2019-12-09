package com.qgg.sample;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.qgg.mvvm.viewmodel.BaseViewModel;
import com.qgg.sample.calculator.CalculatorActivity;
import com.qgg.sample.login.LoginActivity;
import com.qgg.sample.register.RegisterActivity;

/**
 * Description：
 *
 * @author wangqing
 * @date 2019/12/10
 */
public class MainViewModel extends BaseViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void startLoginActivity(Activity activity) {
        activity.startActivity(new Intent(activity, LoginActivity.class));
    }

    public void startRegisterActivity(Activity activity) {
        activity.startActivity(new Intent(activity, RegisterActivity.class));
    }

    public void startCalculatorActivity(Activity activity) {
        activity.startActivity(new Intent(activity, CalculatorActivity.class));
    }
}
