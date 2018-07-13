package com.example.zer.weiyingdemo.view.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.CommentBean;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.presenter.CommentPresenter;
import com.example.zer.weiyingdemo.view.adapter.CommentAdapter;
import com.example.zer.weiyingdemo.view.interfaces.CommentInterV;

import java.util.List;

public class CommentFragment extends BaseFragment<CommentPresenter> implements CommentInterV{
    DetailsBean.RetBean d;
    private View view;
    private CommentAdapter commentAdapter;
    String mediaid;
    private RecyclerView comment_recy;

    public void setMediaId(String mediaid){
        this.mediaid=mediaid;
    }

    @Override
    protected int getChildFragment() {
        return R.layout.fragment_comment;
    }

    @Override
    protected void initView(View view) {
        findId();
        basePresenter.toM(mediaid);
    }

    private void findId() {
        view = getView();
        comment_recy = view.findViewById(R.id.comment_recy);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected CommentPresenter getPresenter() {
        return new CommentPresenter(this);
    }

    private void thisSetAdapter(List<CommentBean.RetBean.ListBean> list){
        if(commentAdapter==null){
            commentAdapter = new CommentAdapter(getActivity());
            commentAdapter.setList(list);
            comment_recy.setLayoutManager(new LinearLayoutManager(getContext()));
            comment_recy.setAdapter(commentAdapter);
        }
    }

    @Override
    public void commentinterv(List<CommentBean.RetBean.ListBean> list) {
        thisSetAdapter(list);
    }
}
