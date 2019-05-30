package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.myapplication.adapter.TabMainAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.MeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;
    private TabMainAdapter adapter;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        tl.setTitle("欢迎");
        setSupportActionBar(tl);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MeFragment());
        strings = new ArrayList<>();
        strings.add("首页");
        strings.add("我的");
        adapter = new TabMainAdapter(getSupportFragmentManager(),fragments,strings);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
}

