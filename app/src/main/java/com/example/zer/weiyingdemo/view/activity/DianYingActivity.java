package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.presenter.DianYingPre;
import com.example.zer.weiyingdemo.view.interfaces.IDianyingView;

public class DianYingActivity extends BaseActivity<DianYingPre> implements IDianyingView {

    private RecyclerView dianying_recycle;
    private TextView dianying_title;

    /*@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianying);
        *//*Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        if (url.equals("")){
            return;
        }*//*
    }*/

    @Override
    int getChildView() {
        return R.layout.activity_dianying;
    }

    @Override
    void initView() {
        dianying_recycle = findViewById(R.id.dianying_recycle);
        dianying_title = findViewById(R.id.dianying_title);
    }

    @Override
    void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        if (title.equals("")){
            dianying_title.setText("默认精选");
        }else{
            dianying_title.setText(title);
        }
        presenter.attachView(this);
    }

    @Override
    DianYingPre setPresenter() {
        return new DianYingPre();
    }
}
