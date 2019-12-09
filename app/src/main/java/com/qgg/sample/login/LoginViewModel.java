package com.qgg.sample.login;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.qgg.mvvm.viewmodel.BaseViewModel;

/**
 * Description：login viewModel
 *
 * @author wangqing
 * @date 2019/12/9 on 14:34
 */
public class LoginViewModel extends BaseViewModel {
    private MutableLiveData<String> mMutableLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        mMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<String> getMutableLiveData() {
        return mMutableLiveData;
    }

    public void login(View view) {
        Toast.makeText(getApplication(), "点击了登录", Toast.LENGTH_SHORT).show();
    }

    public void updatePassword(View view) {
        Toast.makeText(getApplication(), "点击了更新密码", Toast.LENGTH_SHORT).show();
    }

    public void updateAll(View view) {
        Toast.makeText(getApplication(), "点击了更新所有数据", Toast.LENGTH_SHORT).show();
    }
}
