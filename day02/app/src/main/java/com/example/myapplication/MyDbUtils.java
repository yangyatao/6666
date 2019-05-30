package com.example.myapplication;

import com.example.myapplication.dao.DaoMaster;
import com.example.myapplication.dao.DaoSession;
import com.example.myapplication.dao.MyDbBeanDao;

import java.util.ArrayList;

public class MyDbUtils {
    private static volatile MyDbUtils myDbUtils;
    private final MyDbBeanDao dao;

    private MyDbUtils(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApp.getBaseApp(), "user.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getMyDbBeanDao();
        initData();
    }

    private void initData() {
        ArrayList<MyDbBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new MyDbBean(Long.valueOf(i+""),"小明","男"));
        }
        dao.insertOrReplaceInTx(list);
    }

    public static MyDbUtils getMyDbUtils() {
        if (myDbUtils==null) {
            synchronized (MyDbUtils.class) {
                if (myDbUtils==null) {
                    myDbUtils  = new MyDbUtils();
                }
            }
        }
        return myDbUtils;
    }
    public ArrayList<MyDbBean> cha(){
        return (ArrayList<MyDbBean>)dao.queryBuilder().list();
    }
}
