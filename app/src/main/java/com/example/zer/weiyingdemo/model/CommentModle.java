package com.example.zer.weiyingdemo.model;

import com.example.zer.weiyingdemo.model.bean.CommentBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;
import com.example.zer.weiyingdemo.view.interfaces.CommentInterP;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CommentModle {
    private CommentInterP commentInterP;

    public CommentModle(CommentInterP commentInterP) {
        this.commentInterP = commentInterP;
    }

    public void backP(String mediaid){
        RetrofitUtils.getInstance().getApi().comment(mediaid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentBean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(CommentBean value) {
                if(value.getCode().equals("200")){
                    commentInterP.commentinterp(value.getRet().getList());
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
