package com.example.zer.weiyingdemo.presenter;

import com.example.zer.weiyingdemo.view.interfaces.IBaseView;

public class BasePresenter<V extends IBaseView> {
    private V miBaseView;
    public void attachView(V iBaseView){
        this.miBaseView = iBaseView;
    }
    public V getView(){
        return miBaseView;
    }
    public void detach(){
        miBaseView = null;
    }
}
