package com.example.zer.weiyingdemo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.zer.weiyingdemo.presenter.BasePresenter;
import com.example.zer.weiyingdemo.view.interfaces.IBaseView;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getChildView());
        initView();
        initBaseData();
        initData();
    }
    private  void initBaseData(){
        presenter = setPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }else {
            try {
                throw new Exception("您在Activity中没有设置Presenter，请重新创建");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    abstract int getChildView();
    abstract void initView();
    abstract void initData();
    abstract P setPresenter();
    
}
