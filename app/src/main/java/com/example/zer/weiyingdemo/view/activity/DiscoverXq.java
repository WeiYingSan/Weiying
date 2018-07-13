package com.example.zer.weiyingdemo.view.activity;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.DiscoverBean;
import com.example.zer.weiyingdemo.presenter.DiscoverPresenter;
import com.example.zer.weiyingdemo.view.interfaces.IDiscoverView;

public class DiscoverXq extends BaseActivity<DiscoverPresenter> implements IDiscoverView {

    @Override
    int getChildView() {
        return R.layout.activity_discoverxq;
    }

    @Override
    void initView() {

    }

    @Override
    void initData() {

    }

    @Override
    DiscoverPresenter setPresenter() {
        return new DiscoverPresenter();
    }

    @Override
    public void onSuccess(DiscoverBean discoverBean) {

    }

    @Override
    public void onError(String s) {

    }
}
