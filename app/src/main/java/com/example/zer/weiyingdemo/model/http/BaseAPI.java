package com.example.zer.weiyingdemo.model.http;


import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import io.reactivex.Observable;

import retrofit2.http.GET;

public interface BaseAPI {
     @GET("front/homePageApi/homePage.do")
     Observable<ShouYeBean> getEr();

     @GET("front/homePageApi/homePage.do")
     Observable<ShouYeBean> shouye();
}
