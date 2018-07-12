package com.example.zer.weiyingdemo.view.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import com.example.zer.weiyingdemo.presenter.SelecTionPresenter;
import com.example.zer.weiyingdemo.view.adapter.JingCaiAdapter;
import com.example.zer.weiyingdemo.view.interfaces.SelecTionInterV;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class oneFragment extends BaseFragment<SelecTionPresenter> implements SelecTionInterV{

    private View view;
    private SelecTionPresenter presenter;
    private List<ShouYeBean.RetBean.ListBean.ChildListBean> childList;
    private List<String> bannerlist=new ArrayList<>();
    private Banner banner;
    private RecyclerView jingcairecy;
    private List<ShouYeBean.RetBean.ListBean.ChildListBean> jingcailist;
    private JingCaiAdapter jingCaiAdapter;
    private ScrollView shou_scroll;
    private TextView title;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected SelecTionPresenter getPresenter() {
        return new SelecTionPresenter(this);
    }
    @Override
    protected void initData() {
        presenter.toM();
    }

    @Override
    protected void initView(View view) {
        this.view = view;
        if(presenter==null){
            presenter = getPresenter();
        }
        findId();
    }

    private void findId() {
        banner = view.findViewById(R.id.banner);
        jingcairecy = view.findViewById(R.id.jingcairecy);
        shou_scroll = view.findViewById(R.id.shou_scroll);
        title = view.findViewById(R.id.title);
    }

    @Override
    protected int getChildFragment() {
        return R.layout.onefragment;
    }
    class ImageBannerLoader extends ImageLoader{
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
    @Override
    public void selectioninterv(ShouYeBean.RetBean v, boolean b) {
         if(b){
             //banner
             childList = v.getList().get(0).getChildList();
             jingcailist = v.getList().get(2).getChildList();
             for(int i = 0; i< this.childList.size(); i++){
                 String pic = this.childList.get(i).getPic();
                 if(pic!=null){
                     bannerlist.add(pic);
                 }
             }
             banner.setImageLoader(new ImageBannerLoader());
             banner.setImages(bannerlist);
             banner.setDelayTime(2000);
             banner.start();
             //banner
             //精彩推荐
             if(jingCaiAdapter==null){
                 jingcairecy.setNestedScrollingEnabled(false);
                 jingCaiAdapter = new JingCaiAdapter(getActivity());
                 jingCaiAdapter.setList(jingcailist);
                 jingcairecy.setLayoutManager(new LinearLayoutManager(getActivity()));
                 jingcairecy.setAdapter(jingCaiAdapter);
             }

             //精彩推荐
         }else{
             Toast.makeText(getActivity(),"请求失败!",Toast.LENGTH_SHORT).show();
         }
    }
}
