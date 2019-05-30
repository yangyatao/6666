package com.example.myapplication.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.myapplication.MyDbBean;

import com.example.myapplication.dao.MyDbBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myDbBeanDaoConfig;

    private final MyDbBeanDao myDbBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myDbBeanDaoConfig = daoConfigMap.get(MyDbBeanDao.class).clone();
        myDbBeanDaoConfig.initIdentityScope(type);

        myDbBeanDao = new MyDbBeanDao(myDbBeanDaoConfig, this);

        registerDao(MyDbBean.class, myDbBeanDao);
    }
    
    public void clear() {
        myDbBeanDaoConfig.clearIdentityScope();
    }

    public MyDbBeanDao getMyDbBeanDao() {
        return myDbBeanDao;
    }

}