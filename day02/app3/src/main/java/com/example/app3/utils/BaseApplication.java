package com.example.app3.utils;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }

    public static BaseApplication getInstance() {
        return application;
    }
}
