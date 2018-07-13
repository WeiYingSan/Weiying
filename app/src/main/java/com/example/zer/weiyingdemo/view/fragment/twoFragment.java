package com.example.zer.weiyingdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import com.example.zer.weiyingdemo.presenter.TwoFragmentPre;
import com.example.zer.weiyingdemo.view.adapter.TwoAdapter;
import com.example.zer.weiyingdemo.view.interfaces.ITwoFragment;

import java.util.List;

public class twoFragment extends BaseFragment<TwoFragmentPre> implements ITwoFragment{

    private RecyclerView two_recycle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(getChildFragment(), container,false);
        initView(inflate);
        initData();
        return inflate;
    }

    @Override
    protected int getChildFragment() {
        return R.layout.twofragment;
    }
    
    @Override
    protected void initView(View inflate) {
        two_recycle = inflate.findViewById(R.id.two_recycle);
        TwoFragmentPre twoFragmentPre = getPresenter();
        twoFragmentPre.attachView(this);
        twoFragmentPre.getTwo();
    }
    
    @Override
    protected void initData() {
    }
    
    @Override
    protected TwoFragmentPre getPresenter() {
        return new TwoFragmentPre();
    }

    @Override
    public void onSuccess(ShouYeBean bean) {
        Log.e("aaa", "onSuccess: %%%%"+bean.getMsg());
        List<ShouYeBean.RetBean.ListBean> list = bean.getRet().getList();
        TwoAdapter twoAdapter = new TwoAdapter(getActivity());
        twoAdapter.setTwo(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        two_recycle.setLayoutManager(gridLayoutManager);
        two_recycle.setAdapter(twoAdapter);
    }

    @Override
    public void onError(int errCode, String errMessage) {

    }
}
