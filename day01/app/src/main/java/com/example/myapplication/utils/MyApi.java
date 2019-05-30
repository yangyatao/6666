package com.example.myapplication.utils;

import com.example.myapplication.bean.HomeBannerBean;
import com.example.myapplication.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyApi {
    //https://www.wanandroid.com/article/list/0/json
    //https://www.wanandroid.com/banner/json
    String URL = "https://www.wanandroid.com/";
    @GET("article/list/0/json")
    Observable<HomeBean> homeCall();
    @GET("banner/json")
    Observable<HomeBannerBean> bannerCall();
}
