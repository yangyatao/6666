package com.example.myapplication.model;

import com.example.myapplication.base.BaseCallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.bean.MyDbBean;
import com.example.myapplication.utils.MyDbUtils;

import java.util.ArrayList;

public class CollectModel extends BaseModel {
    public void setData(final BaseCallBack<ArrayList<MyDbBean>> baseCallBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<MyDbBean> cha = MyDbUtils.getMyDbUtils().cha();
                if (cha != null && cha.size() > 0) {
                    baseCallBack.cheng(cha);
                } else {
                    baseCallBack.shi("失败");
                }
            }
        }).start();
    }

    public void initData(final MyDbBean bean, final BaseCallBack<String> baseCallBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (bean != null) {
                    MyDbUtils.getMyDbUtils().delete(bean);
                    baseCallBack.cheng("删除成功");
                } else {
                    baseCallBack.shi("删除失败");
                }
            }
        }).start();
    }
}
