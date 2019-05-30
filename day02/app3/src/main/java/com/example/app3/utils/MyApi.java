package com.example.app3.utils;

import com.example.app3.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyApi {
    //https://www.apiopen.top/novelInfoApi?name=%E7%9B%97%E5%A2%93%E7%AC%94%E8%AE%B0
    String URL ="https://www.apiopen.top/";
    @GET("novelInfoApi?name=%E7%9B%97%E5%A2%93%E7%AC%94%E8%AE%B0")
    Observable<MyBean> myCall();
}
