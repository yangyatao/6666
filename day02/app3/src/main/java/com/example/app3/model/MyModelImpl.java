package com.example.app3.model;

import com.example.app3.bean.MyBean;
import com.example.app3.utils.BaseCallBack;
import com.example.app3.utils.HttpUtils;
import com.example.app3.utils.MyApi;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelImpl implements MyModel{
    @Override
    public void getData(final BaseCallBack baseCallBack) {
        MyApi myApi = HttpUtils.getInstance().getApiService(MyApi.URL, MyApi.class);
        Observable<MyBean> call = myApi.myCall();
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBean value) {
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
}
