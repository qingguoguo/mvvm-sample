package com.qgg.mvvm.view;

import android.databinding.ViewDataBinding;

/**
 * Description:拓展BaseView
 *
 * @author wangqing
 * @date 2019/12/13
 */
public interface AssistView<VDB extends ViewDataBinding> extends BaseView<VDB> {
    void showToast(CharSequence text);

    void showLongToast(CharSequence text);
}
