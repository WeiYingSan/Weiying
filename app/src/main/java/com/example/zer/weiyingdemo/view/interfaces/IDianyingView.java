package com.example.zer.weiyingdemo.view.interfaces;

import com.example.zer.weiyingdemo.model.bean.PinDaoBean;

public interface IDianyingView extends IBaseView{
    void onSuccess(PinDaoBean bean);
    void onErr(int errCode,String errMessage);
}
