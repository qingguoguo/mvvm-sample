package com.qgg.sample.register;

import android.view.View;

import com.qgg.mvvm.view.BaseFragment;
import com.qgg.sample.R;
import com.qgg.sample.databinding.FragmentRegisterBinding;

/**
 * Description：
 *
 * @author wangqing
 * @date 2019/12/9
 */
public class RegisterFragment extends BaseFragment<RegisterViewModel, FragmentRegisterBinding> implements View.OnClickListener {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void initBindingView(FragmentRegisterBinding fragmentRegisterBinding) {
        fragmentRegisterBinding.register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mViewModel.register(mViewDataBinding.username.getText().toString(),
                mViewDataBinding.password.getText().toString());
    }
}
