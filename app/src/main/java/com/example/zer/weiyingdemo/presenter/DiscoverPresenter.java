package com.example.zer.weiyingdemo.presenter;

import android.util.Log;

import com.example.zer.weiyingdemo.model.bean.DiscoverBean;
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;
import com.example.zer.weiyingdemo.view.interfaces.IDiscoverView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DiscoverPresenter extends BasePresenter<IDiscoverView> {
    private RetrofitUtils retrofitUtils;

    public DiscoverPresenter(){
        retrofitUtils=RetrofitUtils.getInstance();
    }

    public void getPDiscover(String catalogId,String pnum){
        Observable<DiscoverBean> discover = retrofitUtils.getApi().discover(catalogId, pnum);
        discover.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscoverBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiscoverBean value) {
                        Log.e("dpdp",value.getMsg());
                        String code = value.getCode();
                        if(code.equals("200")){
                            getView().onSuccess(value);
                        }else
                        {
                            getView().onError("发现页面获取错误");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("dpdpdp","error");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
