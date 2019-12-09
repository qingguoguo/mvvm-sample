package com.qgg.sample.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Description：用户Bean类
 *
 * @author wangqing
 * @date 2019/12/5 on 18:17
 */
public class User extends BaseObservable {
    //如果是 public 修饰符，则可以直接在成员变量上方加上 @Bindable 注解
    //如果是 private 修饰符，则在成员变量的 get 方法上添加 @Bindable 注解
    private String mUserName;
    private String mPassword;
    private int mAge;

    public User(String userName, String password, int age) {
        mUserName = userName;
        mPassword = password;
        mAge = age;
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    @Bindable
    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
        notifyChange();
    }

    public void setPassword(String password) {
        mPassword = password;
        notifyPropertyChanged(com.qgg.sample.BR.password);
    }

    @Bindable
    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
