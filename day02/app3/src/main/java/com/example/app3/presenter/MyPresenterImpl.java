package com.example.app3.presenter;

import com.example.app3.bean.MyBean;
import com.example.app3.model.MyModel;
import com.example.app3.utils.BaseCallBack;
import com.example.app3.view.MyView;

public class MyPresenterImpl implements MyPresenter, BaseCallBack {
    private MyModel myModel;
    private MyView myView;

    public MyPresenterImpl(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getData() {
        if (myModel!=null) {
            myModel.getData(this);
        }
    }

    @Override
    public void cheng(MyBean bean) {
        if (myView!=null) {
            myView.cheng(bean);
        }
    }

    @Override
    public void shi(String str) {

        if (myView!=null) {
            myView.shi(str);
        }
    }
}
