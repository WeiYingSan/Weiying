package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.PinDaoBean;
import com.example.zer.weiyingdemo.presenter.DianYingPre;
import com.example.zer.weiyingdemo.view.adapter.PindaoAdapter;
import com.example.zer.weiyingdemo.view.interfaces.IDianyingView;

import java.util.List;

public class DianYingActivity extends BaseActivity<DianYingPre> implements IDianyingView {

    private RecyclerView dianying_recycle;
    private TextView dianying_title;
    
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
        String title = intent.getStringExtra("title");
        String id = intent.getStringExtra("id");
        Log.e("zer", "initData: &&&"+id);
        if (title.equals("")){
            dianying_title.setText("默认精选");
        }else{
            dianying_title.setText(title);
        }
        presenter.attachView(this);
        presenter.getPindao(id);
    }

    @Override
    DianYingPre setPresenter() {
        return new DianYingPre();
    }
    
    @Override
    public void onSuccess(PinDaoBean bean) {
        List<PinDaoBean.RetBean.ListBean> beanList = bean.getRet().getList();
        PindaoAdapter pindaoAdapter = new PindaoAdapter(this,beanList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        dianying_recycle.setLayoutManager(gridLayoutManager);
        dianying_recycle.setAdapter(pindaoAdapter);
    }

    @Override
    public void onErr(int errCode, String errMessage) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
