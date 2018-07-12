package com.example.zer.weiyingdemo.model;

import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;
import com.example.zer.weiyingdemo.view.interfaces.DetailsInterP;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailsModle {
    private DetailsInterP detailsInterP;

    public DetailsModle(DetailsInterP detailsInterP) {
        this.detailsInterP = detailsInterP;
    }

    public void backP(String id){
        RetrofitUtils
                .getInstance()
                .getApi()
                .details(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsBean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(DetailsBean value) {
                 detailsInterP.detailsinterp(value.getRet());
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onComplete() {
            }
        });
    }

}
