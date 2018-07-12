package com.example.zer.weiyingdemo.presenter;

import android.util.Log;

import com.example.zer.weiyingdemo.model.DetailsModle;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.view.interfaces.DetailsInterP;
import com.example.zer.weiyingdemo.view.interfaces.DetailsInterV;

public class DetailsPresenter extends BasePresenter implements DetailsInterP{
    private DetailsInterV detailsInterV;

    public DetailsPresenter(DetailsInterV detailsInterV) {
        this.detailsInterV = detailsInterV;
    }

    private DetailsModle detailsModle;

    public void toM(String id){
        Log.d("aaaa", "toM: %%%"+id);
        if(detailsModle==null){
            detailsModle = new DetailsModle(this);
        }
        detailsModle.backP(id);
    }

    @Override
    public void detailsinterp(DetailsBean.RetBean p) {
        detailsInterV.detailsinterv(p);
    }
}
