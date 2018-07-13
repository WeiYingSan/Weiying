package com.example.zer.weiyingdemo.presenter;

import android.util.Log;

import com.example.zer.weiyingdemo.model.bean.FuliBean;
import com.example.zer.weiyingdemo.model.http.RetroUtilFl;
import com.example.zer.weiyingdemo.view.interfaces.IFuliView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FuliPresenter extends BasePresenter<IFuliView>{

    private final RetroUtilFl utilFl;

    public FuliPresenter(){
        utilFl = RetroUtilFl.getInstance();
    }
    public void fuli(int page){
     Observable<FuliBean> observable = utilFl.getApi().getFuli(page);
     observable.subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Observer<FuliBean>() {
                 @Override
                 public void onSubscribe(Disposable d) {
                     
                 }

                 @Override
                 public void onNext(FuliBean value) {
                     Log.e("zer", "onSuccess: %%%"+value.getResults().get(0).getType());
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
