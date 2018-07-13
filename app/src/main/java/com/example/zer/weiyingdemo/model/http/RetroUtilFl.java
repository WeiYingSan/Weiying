package com.example.zer.weiyingdemo.model.http;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroUtilFl {
    private Retrofit retrofit;

    private RetroUtilFl() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("TAG", "log: &&&"+message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        //建立retrofit对象
        retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//默认gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用RxJava2的适配器
                .build();
    }
    //单列模式
    public static RetroUtilFl INSTANCE;

    public static RetroUtilFl getInstance() {
        if (INSTANCE == null) {
            synchronized (RetroUtilFl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetroUtilFl();
                }
            }
        }
        return INSTANCE;
    }

    //创建方法,供调用
    public GankApi getApi() {
        //获取接口
        GankApi gaseAPI = retrofit.create(GankApi.class);
        return gaseAPI;
    }
}
