package com.example.zer.weiyingdemo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.zer.weiyingdemo.MyApp;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.db.ShouCangBeanDao;
import com.example.zer.weiyingdemo.model.bean.ShouCangBean;
import com.example.zer.weiyingdemo.view.adapter.ShouCangAdapter;

import java.util.List;

public class ShouCangActivity extends AppCompatActivity{

    private RecyclerView shoucang_recycle;
    private ShouCangBeanDao shouCangBeanDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoucang_activity);
        shouCangBeanDao = MyApp.instances.getDaoSession().getShouCangBeanDao();
        shoucang_recycle = findViewById(R.id.shoucang_recycle);
        initData();
    }

    private void initData() {
        List<ShouCangBean> shouCangBeans = shouCangBeanDao.loadAll();
        ShouCangAdapter shouCangAdapter = new ShouCangAdapter(this,shouCangBeans);
        shoucang_recycle.setLayoutManager(new GridLayoutManager(this,3, LinearLayoutManager.VERTICAL,false));
        shoucang_recycle.setAdapter(shouCangAdapter);
    }
}
