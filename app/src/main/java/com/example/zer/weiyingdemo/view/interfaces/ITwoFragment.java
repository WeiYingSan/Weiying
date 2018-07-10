package com.example.zer.weiyingdemo.view.interfaces;

import com.example.zer.weiyingdemo.model.bean.ShouYeBean;

public interface ITwoFragment extends IBaseView{
    void onSuccess(ShouYeBean bean);
    void onError(int errCode,String errMessage);
}
