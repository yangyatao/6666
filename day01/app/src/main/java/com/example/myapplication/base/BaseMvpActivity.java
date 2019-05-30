package com.example.myapplication.base;

public abstract class BaseMvpActivity<P extends BasePresenter,M extends BaseModel,V extends BaseView>
        extends BaseActivity{

    protected P pre;

    @Override
    protected void initMvp() {
        pre = initPresenter();
        if (pre !=null) {
            pre.initModel(addModel());
            pre.initMvpView(addView());
        }
    }

    protected abstract V addView();

    protected abstract M addModel();

    protected abstract P initPresenter();
}
