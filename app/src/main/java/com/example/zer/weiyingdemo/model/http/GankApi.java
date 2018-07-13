package com.example.zer.weiyingdemo.model.http;

import com.example.zer.weiyingdemo.model.bean.FuliBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GankApi {
    //福利接口
    @GET("data/福利/20/{page}")
    Observable<FuliBean> getFuli(@Path("page") int page);
}
