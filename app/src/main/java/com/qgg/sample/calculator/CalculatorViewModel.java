package com.qgg.sample.calculator;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.qgg.mvvm.viewmodel.BaseViewModel;

import java.util.Stack;

/**
 * Description:计算器 ViewModel
 *
 * @author wangqing
 * @date 2019/12/16
 */
public class CalculatorViewModel extends BaseViewModel {
    private final static String ADD = "+";
    private final static String MINUS = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";

    private StatusType mStatusType = StatusType.NONE;
    private Stack<Integer> mNumStack;
    private Stack<String> mSymbolStack;

    private MutableLiveData<String> mResultLiveData;
    private MutableLiveData<String> mProcessLiveData;

    public CalculatorViewModel(@NonNull Application application) {
        super(application);
        mNumStack = new Stack<>();
        mSymbolStack = new Stack<>();
    }

    public MutableLiveData<String> getResultLiveData() {
        if (mResultLiveData == null) {
            mResultLiveData = new MutableLiveData<>();
        }
        return mResultLiveData;
    }

    public MutableLiveData<String> getProcessLiveData() {
        if (mProcessLiveData == null) {
            mProcessLiveData = new MutableLiveData<>();
        }
        return mProcessLiveData;
    }

    private void setStatus(StatusType symbol) {
        mStatusType = symbol;
    }

    /**
     * 加法
     */
    public void add() {
        addSymbol(ADD);
    }

    /**
     * 减法
     */
    public void minus() {
        addSymbol(MINUS);
    }

    /**
     * 乘法
     */
    public void multiply() {
        addSymbol(MULTIPLY);
    }

    /**
     * 除法
     */
    public void divide() {
        addSymbol(DIVIDE);
    }

    private void addSymbol(String symbol) {
        if (mStatusType == StatusType.SYMBOL) {
            if (!mSymbolStack.empty()) {
                mSymbolStack.pop();
                mSymbolStack.add(symbol);
                showProcess(symbol, false);
            }
        } else {
            if (!mNumStack.empty()) {
                showProcess(symbol, true);
                mSymbolStack.add(symbol);
            }
        }
        setStatus(StatusType.SYMBOL);
    }

    /**
     * 回退
     */
    public void clear() {
        if (checkEmptyList() || mStatusType == StatusType.EQUAL) {
            return;
        }
        String temp;
        if (mStatusType == StatusType.NUM) {
            Integer pop = mNumStack.pop();
            temp = String.valueOf(pop);
        } else {
            temp = mSymbolStack.pop();
        }
        showProcess(temp, false);
    }

    /**
     * 等号
     */
    public void equal() {
        if (checkEmptyList()) {
            return;
        }
        int sum = 0;
        String symbol = "";
        for (int i = 0; i < mNumStack.size(); i++) {
            Integer integer = mNumStack.get(i);
            if (i == 0) {
                sum = sum + integer;
            }
            switch (symbol) {
                case ADD:
                    sum = sum + integer;
                    break;
                case MINUS:
                    sum = sum - integer;
                    break;
                case MULTIPLY:
                    sum = sum * integer;
                    break;
                case DIVIDE:
                    sum = sum / integer;
                    break;
            }
            if (!mSymbolStack.empty() && mSymbolStack.size() > i) {
                symbol = mSymbolStack.get(i);
            }
        }
        mResultLiveData.setValue(String.valueOf(sum));
        mStatusType = StatusType.EQUAL;
        mSymbolStack.clear(); // 清空数据
        mNumStack.clear();
        mNumStack.add(sum);
    }

    private boolean checkEmptyList() {
        return mNumStack.empty() || mSymbolStack.empty();
    }

    public void num(int num) {
        if (mStatusType == StatusType.NUM) { // 更新数据
            Integer pop = mNumStack.pop();
            mNumStack.add(Integer.valueOf(String.valueOf(pop) + num));
            showProcess(String.valueOf(num), true);
        } else {
            if (mStatusType == StatusType.EQUAL) {
                mProcessLiveData.setValue(String.valueOf(num)); // 等号模式下应该是重新插入结果
                mResultLiveData.setValue(""); // 重置上次计算的结果
                mNumStack.clear();
            } else {
                showProcess(String.valueOf(num), true);
            }
            mNumStack.add(num);
        }
        setStatus(StatusType.NUM);
    }

    private void showProcess(String text, boolean isAdd) {
        if (mProcessLiveData.getValue() != null) {
            if (isAdd) {
                mProcessLiveData.setValue(mProcessLiveData.getValue() + text);
            } else {
                mProcessLiveData.setValue(mProcessLiveData.getValue().replace(text, ""));
            }
        } else {
            mProcessLiveData.setValue(text);
        }
    }

    private enum StatusType {
        NONE, NUM, SYMBOL, EQUAL
    }
}
