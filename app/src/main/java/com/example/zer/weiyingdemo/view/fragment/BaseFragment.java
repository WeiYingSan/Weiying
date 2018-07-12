package com.example.zer.weiyingdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zer.weiyingdemo.presenter.BasePresenter;
import com.example.zer.weiyingdemo.view.interfaces.IBaseView;

public abstract class BaseFragment<B extends BasePresenter> extends Fragment implements IBaseView{
    B basePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getChildFragment(), container, false);
        initFragment();
        initView(view);
        initData();
        return view;
    }

    public void initFragment(){
        basePresenter=getPresenter();
    }

    protected abstract int getChildFragment();
    protected abstract void initView(View view);
    protected abstract void initData();
    protected abstract B getPresenter();
    
}
