package com.example.zer.weiyingdemo.view.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.FuliBean;
import com.example.zer.weiyingdemo.presenter.FuliPresenter;
import com.example.zer.weiyingdemo.view.adapter.FuliAdapter;
import com.example.zer.weiyingdemo.view.interfaces.IFuliView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class FuliActivity extends BaseActivity<FuliPresenter> implements IFuliView {

    private RecyclerView fuli_recycle;
    private SmartRefreshLayout fuli_smart;
    int page = 0;

    @Override
    int getChildView() {
        return R.layout.activity_fuli;
    }

    @Override
    void initView() {
        fuli_recycle = findViewById(R.id.fuli_recycle);
        fuli_smart = findViewById(R.id.fuli_smart);
        fuli_smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
                fuli_smart.finishLoadMore(1000);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
               page = 0;
               initData();
               fuli_smart.finishRefresh(1000);
            }
        });
    }

    @Override
    void initData() {
       presenter.attachView(this);
       presenter.fuli(page);
    }

    @Override
    FuliPresenter setPresenter() {
        return new FuliPresenter();
    }

    @Override
    public void onSuccess(FuliBean bean) {
        Log.e("zer", "onSuccess: %%%"+bean.getResults().get(0).getType());
        List<FuliBean.ResultsBean> list = bean.getResults();
        FuliAdapter fuliAdapter = new FuliAdapter(this,list);
        fuli_recycle.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        fuli_recycle.setAdapter(fuliAdapter);
    }
}
