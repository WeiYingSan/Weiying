package com.example.zer.weiyingdemo.presenter;

import android.util.Log;

import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;
import com.example.zer.weiyingdemo.view.interfaces.ITwoFragment;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TwoFragmentPre extends BasePresenter<ITwoFragment>{

    private final RetrofitUtils retrofitUtils;

    public TwoFragmentPre(){
        retrofitUtils = RetrofitUtils.getInstance();
    }
    public void getTwo(){
        Observable<ShouYeBean> observable = retrofitUtils.getApi().getEr();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShouYeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        
                    }

                    @Override
                    public void onNext(ShouYeBean value) { 
                        Log.e("aaa", "onNext: %%%%%%%%"+value.getMsg());
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
