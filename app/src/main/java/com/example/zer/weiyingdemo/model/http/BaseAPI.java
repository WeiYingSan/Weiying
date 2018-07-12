package com.example.zer.weiyingdemo.model.http;


import com.example.zer.weiyingdemo.model.bean.DiscoverBean;
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseAPI {
     @GET("front/homePageApi/homePage.do")
     Observable<ShouYeBean> getEr();

     @GET("front/homePageApi/homePage.do")
     Observable<ShouYeBean> shouye();

     @POST("front/columns/getVideoList.do")
     @FormUrlEncoded
     Observable<DiscoverBean> discover(@Field("catalogId") String catalogId,
                                       @Field("pnum") String pnum);
}
