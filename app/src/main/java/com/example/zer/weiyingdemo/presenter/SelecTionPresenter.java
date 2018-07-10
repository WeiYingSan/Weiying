package com.example.zer.weiyingdemo.presenter;

import com.example.zer.weiyingdemo.model.SelecTionModle;
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import com.example.zer.weiyingdemo.view.interfaces.SelecTionInterP;
import com.example.zer.weiyingdemo.view.interfaces.SelecTionInterV;

public class SelecTionPresenter extends BasePresenter implements SelecTionInterP{

    private SelecTionInterV selecTionInterV;
    private SelecTionModle selecTionModle;

    public SelecTionPresenter(SelecTionInterV selecTionInterV) {
        this.selecTionInterV = selecTionInterV;
    }
    public void toM(){
        if(selecTionModle==null){
            selecTionModle = new SelecTionModle(this);
        }
        selecTionModle.backP();

    }

    @Override
    public void selectioninterp(ShouYeBean.RetBean p) {
        selecTionInterV.selectioninterv(p,true);
    }

    @Override
    public void errow(ShouYeBean.RetBean p) {
        selecTionInterV.selectioninterv(p,false);
    }
}
