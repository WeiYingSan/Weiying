package com.example.zer.weiyingdemo.model.http;


import com.example.zer.weiyingdemo.model.bean.CommentBean;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.model.bean.DiscoverBean;
import com.example.zer.weiyingdemo.model.bean.FuzzyQueryBean;
import com.example.zer.weiyingdemo.model.bean.PinDaoBean;
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseAPI {
     @GET("front/homePageApi/homePage.do")
     Observable<ShouYeBean> getEr();

     @GET("front/homePageApi/homePage.do")
     Observable<ShouYeBean> shouye();

     @POST("front/columns/getVideoList.do")
     @FormUrlEncoded
     Observable<DiscoverBean> discover(@Field("catalogId") String catalogId,
                                       @Field("pnum") String pnum);


     @POST("front/videoDetailApi/videoDetail.do")
     @FormUrlEncoded
     Observable<DetailsBean> details(
         @Field("mediaId")String mediaid
     );

     @GET("front/columns/getVideoList.do")
     Observable<PinDaoBean> pindao(@Query("catalogId")String catalogId);

     @POST("front/Commentary/getCommentList.do")
     @FormUrlEncoded
     Observable<CommentBean> comment(
             @Field("mediaId")String mediaid
     );
     @POST("front/searchKeyWordApi/getVideoListByKeyWord.do")
     @FormUrlEncoded
     Observable<FuzzyQueryBean>
     getVideoByKeyWord(
             @Field("keyword") String keyword
     );
}
