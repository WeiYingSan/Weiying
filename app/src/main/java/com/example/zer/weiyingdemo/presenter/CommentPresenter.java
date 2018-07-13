package com.example.zer.weiyingdemo.presenter;

import com.example.zer.weiyingdemo.model.CommentModle;
import com.example.zer.weiyingdemo.model.bean.CommentBean;
import com.example.zer.weiyingdemo.view.interfaces.CommentInterP;
import com.example.zer.weiyingdemo.view.interfaces.CommentInterV;

import java.util.List;

public class CommentPresenter extends BasePresenter implements CommentInterP{
    private CommentInterV commentInterV;
    private CommentModle commentModle;

    public CommentPresenter(CommentInterV commentInterV) {
        this.commentInterV = commentInterV;
    }

    public void toM(String mediaid) {
        if(commentModle==null){
            commentModle = new CommentModle(this);
        }
        commentModle.backP(mediaid);
    }
    @Override
    public void commentinterp(List<CommentBean.RetBean.ListBean> list) {
        commentInterV.commentinterv(list);
    }
}
