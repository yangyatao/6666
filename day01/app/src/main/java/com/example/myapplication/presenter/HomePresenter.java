package com.example.myapplication.presenter;

import com.example.myapplication.base.BaseCallBack;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.HomeBannerBean;
import com.example.myapplication.bean.HomeBean;
import com.example.myapplication.model.HomeModel;
import com.example.myapplication.view.HomeView;

public class HomePresenter extends BasePresenter<HomeModel,HomeView> {
    public void setData() {
        if (m!=null) {
            m.setData(new BaseCallBack<HomeBean>() {
                @Override
                public void cheng(HomeBean bean) {
                    if (v!=null) {
                        v.chen(bean);
                    }
                }

                @Override
                public void shi(String str) {
                    if (v!=null) {
                        v.sh(str);
                    }
                }
            });
        }
    }

    public void initData() {
        if (m!=null) {
            m.initData(new BaseCallBack<HomeBannerBean>() {
                @Override
                public void cheng(HomeBannerBean bean) {
                    if (v!=null) {
                        v.cheng(bean);
                    }
                }

                @Override
                public void shi(String str) {
                    if (v!=null) {
                        v.shi(str);
                    }
                }
            });
        }
    }

    public void add(HomeBean.DataBean.DatasBean datasBean) {
        if (m!=null) {
            m.add(datasBean,new BaseCallBack<String>() {
                @Override
                public void cheng(String s) {
                    if (v!=null) {
                        v.ch(s);
                    }
                }

                @Override
                public void shi(String str) {
                    if (v!=null) {
                        v.s(str);
                    }
                }
            });
        }
    }
}
