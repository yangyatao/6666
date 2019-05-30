package com.example.myapplication.presenter;

import com.example.myapplication.base.BaseCallBack;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.MyDbBean;
import com.example.myapplication.model.CollectModel;
import com.example.myapplication.view.CollectView;

import java.util.ArrayList;

public class CollectP extends BasePresenter<CollectModel,CollectView> {
    public void setData() {
        if (m!=null) {
            m.setData(new BaseCallBack<ArrayList<MyDbBean>>() {
                @Override
                public void cheng(ArrayList<MyDbBean> myDbBeans) {
                    if (v!=null) {
                        v.cheng(myDbBeans);
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

    public void initData(MyDbBean bean) {
        if (m!=null) {
            m.initData(bean, new BaseCallBack<String>() {
                @Override
                public void cheng(String s) {
                    if (v!=null) {
                        v.chen(s);
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
}
