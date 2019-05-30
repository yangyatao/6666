package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);

        initMvp();
        initView();
        initData();
        initListeren();
    }

    protected void initMvp() {

    }

    protected void initView() {

    }

    protected void initData() {
    }

    protected void initListeren() {

    }

    protected abstract int initLayout();

}
