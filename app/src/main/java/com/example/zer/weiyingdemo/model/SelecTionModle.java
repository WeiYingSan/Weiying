package com.example.zer.weiyingdemo.model;

import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;
import com.example.zer.weiyingdemo.view.interfaces.SelecTionInterP;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SelecTionModle {
    private SelecTionInterP selecTionInterP;

    public SelecTionModle(SelecTionInterP selecTionInterP) {
        this.selecTionInterP = selecTionInterP;
    }

    public void backP(){
          Observable<ShouYeBean> shouye =  RetrofitUtils.getInstance().getApi().shouye();
          shouye.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<ShouYeBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {
                     }
                     @Override
                     public void onNext(ShouYeBean value) {
                         if(value.getCode().equals("200")){
                             selecTionInterP.selectioninterp(value.getRet());
                         }else{
                             selecTionInterP.errow(value.getRet());
                         }
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
