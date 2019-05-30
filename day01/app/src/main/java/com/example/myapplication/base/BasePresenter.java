package com.example.myapplication.base;

public abstract class BasePresenter <M extends BaseModel,V extends BaseView>{
    protected M m;
    protected V v;
    public void initModel(M m){
        this.m = m;
    }
    public void initMvpView(V v){
        this.v = v;
    }
}