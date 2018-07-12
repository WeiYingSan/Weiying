package com.example.zer.weiyingdemo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.view.adapter.BriefingSesstionAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class BriefingSesstionFragment extends Fragment{

    DetailsBean.RetBean d;

    private View view;
    private List<DetailsBean.RetBean.ListBean.ChildListBean> childList;
    private TextView briefing_daoyan;
    private TextView briefing_jianjie;
    private TextView briefing_zhankai;
    private TextView briefing_jianjie_default;
    boolean o=false;
    private RecyclerView briefing_recy;
    private BriefingSesstionAdapter briefingSesstionAdapter;

    @Override
    public void onDestroy() {
        //EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //EventBus.getDefault().register(this);
        view = inflater.inflate(R.layout.fragment_briefing, container, false);
        findId();
        if(d!=null){
            //得到传过来的值
            childList = d.getList().get(0).getChildList();
            //赋值  导演-简介
            briefing_daoyan.setText(d.getDirector()+"");
            briefing_jianjie.setText(d.getDescription()+"");
            briefing_jianjie_default.setText(d.getDescription() + "");
            briefing_zhankai.setText("展开");

            briefing_recy.setNestedScrollingEnabled(false);
            briefingSesstionAdapter = new BriefingSesstionAdapter(getActivity());
            briefingSesstionAdapter.setList(d.getList().get(0).getChildList());
            briefing_recy.setLayoutManager(new GridLayoutManager(getContext(),3, LinearLayoutManager.VERTICAL,false));
            briefing_recy.setAdapter(briefingSesstionAdapter);
        }
        //展开收起监听
        briefing_zhankai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(o){
                    briefing_jianjie_default.setVisibility(View.VISIBLE);
                    briefing_jianjie.setVisibility(View.GONE);
                    briefing_zhankai.setText("展开");
                    o=false;
                }else{
                    briefing_jianjie_default.setVisibility(View.GONE);
                    briefing_jianjie.setVisibility(View.VISIBLE);
                    briefing_zhankai.setText("收起");
                    o=true;
                }
            }
        });
        return view;
    }
    private void findId() {

        briefing_daoyan = view.findViewById(R.id.briefing_daoyan);
        briefing_jianjie = view.findViewById(R.id.briefing_jianjie);
        briefing_zhankai = view.findViewById(R.id.briefing_zhankai);
        briefing_jianjie_default = view.findViewById(R.id.briefing_jianjie_default);
        briefing_recy = view.findViewById(R.id.briefing_recy);
    }
    //@Subscribe(threadMode = ThreadMode.MAIN , sticky = true)
    public void setData(DetailsBean.RetBean d){
        Log.d("TAG", "setData: EventBut传过来的数据"+d.getDirector());
       this.d=d;
    }
}
