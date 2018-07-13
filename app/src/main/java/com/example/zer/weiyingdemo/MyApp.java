package com.example.zer.weiyingdemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.zer.weiyingdemo.db.DaoMaster;
import com.example.zer.weiyingdemo.db.DaoSession;

public class MyApp extends Application{
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    //静态单例
    public static MyApp instances;
    public static MyApp getInstances(){
        return instances;
    }
    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "sport-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instances=this;
        setDatabase();

    }
}
