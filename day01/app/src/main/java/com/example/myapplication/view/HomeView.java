package com.example.myapplication.view;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.HomeBannerBean;
import com.example.myapplication.bean.HomeBean;

public interface HomeView extends BaseView {
    void shi(String str);

    void cheng(HomeBannerBean bean);

    void sh(String str);

    void chen(HomeBean bean);

    void s(String str);

    void ch(String s);
}
