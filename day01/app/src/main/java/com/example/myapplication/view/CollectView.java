package com.example.myapplication.view;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.MyDbBean;

import java.util.ArrayList;

public interface CollectView extends BaseView {
    void cheng(ArrayList<MyDbBean> myDbBeans);

    void shi(String str);

    void chen(String s);

    void sh(String str);

}
