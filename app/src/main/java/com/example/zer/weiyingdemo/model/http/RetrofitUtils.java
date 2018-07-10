package com.example.zer.weiyingdemo.model.http;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private Retrofit retrofit;

    private RetrofitUtils() {
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
                .baseUrl(Constant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//默认gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用RxJava2的适配器
                .build();
    }
    //单列模式
    public static RetrofitUtils INSTANCE;

    public static RetrofitUtils getInstance() {
        if (INSTANCE == null) {
            synchronized (RetrofitUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitUtils();
                }
            }
        }
        return INSTANCE;
    }

    //创建方法,供调用
    public BaseAPI getApi() {
        //获取接口
        BaseAPI baseAPI = retrofit.create(BaseAPI.class);
        return baseAPI;
    }
}
