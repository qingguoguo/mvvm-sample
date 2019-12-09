package com.qgg.sample.login;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.qgg.mvvm.view.BaseActivity;
import com.qgg.sample.R;
import com.qgg.sample.databinding.LoginActivityBinding;

/**
 * Description：登录页面
 *
 * @author wangqing
 * @date 2019/12/9 on 14:22
 */
public class LoginActivity extends BaseActivity<LoginViewModel, LoginActivityBinding> implements View.OnClickListener {
    private User mUser;

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    public void initBindingView(LoginActivityBinding loginActivityBinding) {
        loginActivityBinding.setClickEvent(this);
        mUser = new User("wangqing", "123456", 18);
        loginActivityBinding.setUser(mUser);
        mViewModel.getMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mUser.setPassword(s);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.login) {
            Toast.makeText(this, "点击了登录", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.update_password) {
            mUser.setAge(mUser.getAge() + 1);
            mUser.setPassword(mUser.getPassword() + "p");
            mViewModel.getMutableLiveData().setValue("dddddddd");
            mViewModel.getMutableLiveData().postValue("dddddddd");
        } else if (id == R.id.update_data_all) {
            mUser.setAge(mUser.getAge() + 2);
            mUser.setUserName(mUser.getUserName() + "w");
        }
    }
}
