package com.example.zer.weiyingdemo.view.interfaces;

import com.example.zer.weiyingdemo.model.bean.DiscoverBean;

public interface IDiscoverView extends IBaseView{
    void onSuccess(DiscoverBean discoverBean);
    void onError(String s);
}
