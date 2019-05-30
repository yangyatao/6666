package com.example.myapplication.utils;

import com.example.myapplication.base.BaseApp;
import com.example.myapplication.bean.MyDbBean;
import com.example.myapplication.dao.DaoMaster;
import com.example.myapplication.dao.DaoSession;
import com.example.myapplication.dao.MyDbBeanDao;

import java.util.ArrayList;

public class MyDbUtils {
    private static volatile MyDbUtils myDbUtils;
    private final MyDbBeanDao dao;

    private MyDbUtils(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApp.getBaseApp(), "ya.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getMyDbBeanDao();
    }

    public static MyDbUtils getMyDbUtils() {
        if (myDbUtils==null) {
            synchronized (MyDbUtils.class) {
                if (myDbUtils==null) {
                    myDbUtils = new MyDbUtils();
                }
            }
        }
        return myDbUtils;
    }
    public void add(MyDbBean bean){
        dao.insert(bean);
    }
    public void delete(MyDbBean bean){
        dao.delete(bean);
    }
    public ArrayList<MyDbBean> cha(){
        return (ArrayList<MyDbBean>) dao.queryBuilder().list();
    }

}
