package com.qgg.sample.calculator;

import com.qgg.mvvm.view.BaseActivity;
import com.qgg.sample.R;
import com.qgg.sample.databinding.ActivityCalculatorBinding;

public class CalculatorActivity extends BaseActivity<CalculatorViewModel, ActivityCalculatorBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_calculator;
    }

    @Override
    protected void initData() {
        mViewDataBinding.setCalculatorModel(mViewModel);

//        mViewModel.getResultLiveData().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(@Nullable Integer integer) {
//                mViewDataBinding.result.setText(String.valueOf(integer));
//            }
//        });

        mViewDataBinding.setLifecycleOwner(this);
    }
}
