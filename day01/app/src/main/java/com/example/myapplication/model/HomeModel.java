package com.example.myapplication.model;

import com.example.myapplication.base.BaseCallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.bean.HomeBannerBean;
import com.example.myapplication.bean.HomeBean;
import com.example.myapplication.bean.MyDbBean;
import com.example.myapplication.utils.MyApi;
import com.example.myapplication.utils.MyDbUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModel extends BaseModel {
    public void initData(final BaseCallBack<HomeBannerBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyApi.URL)
                        .build();
                MyApi myApi = retrofit.create(MyApi.class);
                Observable<HomeBannerBean> call = myApi.bannerCall();
                call.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<HomeBannerBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(HomeBannerBean value) {
                                if (value != null) {
                                    baseCallBack.cheng(value);
                                } else {
                                    baseCallBack.shi("失败");
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                                baseCallBack.shi(e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

    }

    public void setData(final BaseCallBack<HomeBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(MyApi.URL)
                        .build();
                MyApi myApi = retrofit.create(MyApi.class);
                Observable<HomeBean> call = myApi.homeCall();
                call.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<HomeBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(HomeBean value) {
                                if (value != null) {
                                    baseCallBack.cheng(value);
                                } else {
                                    baseCallBack.shi("失败");
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                baseCallBack.shi(e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
    }

    public void add(final HomeBean.DataBean.DatasBean datasBean, final BaseCallBack<String> baseCallBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (datasBean != null) {
                    MyDbBean bean = new MyDbBean();
                    bean.setId(null);
                    bean.setImg(datasBean.getEnvelopePic());
                    bean.setTitle(datasBean.getSuperChapterName());
                    bean.setName(datasBean.getTitle());
                    bean.setTime(datasBean.getAuthor());
                    bean.setLink(datasBean.getLink());
                    MyDbUtils.getMyDbUtils().add(bean);
                    baseCallBack.cheng("添加成功");
                } else {
                    baseCallBack.shi("添加失败");
                }
            }
        }).start();
    }
}
