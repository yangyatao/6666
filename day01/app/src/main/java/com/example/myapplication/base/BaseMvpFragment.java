package com.example.myapplication.base;

public abstract class BaseMvpFragment<P extends BasePresenter,M extends BaseModel,V extends  BaseView>
        extends BaseFragment{

    protected P myPre;

    @Override
    protected void initMvp() {
        myPre = initPresenter();
        if (myPre!=null) {
            myPre.initModel(addModel());
            myPre.initMvpView(addView());
        }
    }

    protected abstract V addView();

    protected abstract M addModel();

    protected abstract P initPresenter();
}
