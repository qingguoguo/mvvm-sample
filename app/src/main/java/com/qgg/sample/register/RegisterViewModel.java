package com.qgg.sample.register;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.qgg.mvvm.util.LogUtil;
import com.qgg.mvvm.viewmodel.BaseViewModel;

/**
 * Description:
 *
 * @author wangqing
 * @date 2019/12/11
 */
public class RegisterViewModel extends BaseViewModel {
    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void register(String name, String password) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplication(), "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            // 发起注册请求
            Toast.makeText(getApplication(), "点击了注册按钮", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCleared() {
        // ViewModel onCleared
        LogUtil.d("RegisterViewModel", "onCleared ", this);
    }
}
