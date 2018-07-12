package com.example.zer.weiyingdemo.presenter;

import android.util.Log;

import com.example.zer.weiyingdemo.model.bean.PinDaoBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;
import com.example.zer.weiyingdemo.view.interfaces.IDianyingView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DianYingPre extends BasePresenter<IDianyingView>{

    private final RetrofitUtils utils;

    public DianYingPre(){
        utils = RetrofitUtils.getInstance();
    }
    public void getPindao(String id){
        Log.e("zer", "getPindao: %%%"+id);
        Observable<PinDaoBean> observable = utils.getApi().pindao(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PinDaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        
                    }

                    @Override
                    public void onNext(PinDaoBean value) {
                      getView().onSuccess(value);
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
