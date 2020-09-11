package com.goldze.mvvmhabit.ui.register;

import android.os.Bundle;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.ActivityRegisterBinding;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.tatarka.bindingcollectionadapter2.BR;

/**
 * @author ailibin
 * @date: 2020/9/10
 * @description: 注册activity
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding,RegisterViewModel>  {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_register;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
