package com.example.zer.weiyingdemo.view.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
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
    private GradationScrollView shou_scroll;
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
        title.setVisibility(View.GONE);
        presenter = getPresenter();
        presenter.attachView(this);
        presenter.toM();
        //scroll滑动监听
        scrollListenner();
    }

    private void scrollListenner() {
        shou_scroll.setScrollViewListener(new GradationScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
                if (y <= 1) {  //设置标题的背景颜色
                    title.setBackgroundColor(Color.argb((int) 0, 144,151,166));
                    title.setVisibility(View.GONE);
                } else if (y > 0 && y <= 500) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                    title.setVisibility(View.VISIBLE);
                    float scale = (float) y / 500;
                    float alpha = (255 * scale);
                    title.setTextColor(Color.argb((int) alpha, 255,255,255));
                    title.setBackgroundColor(Color.argb((int) alpha, 144,151,166));
                } else {  //滑动到banner下面设置普通颜色
                    title.setBackgroundColor(Color.argb((int) 255, 144,151,166));
                }
            }
        });
    }

    @Override
    protected void initView(View view) {
        this.view = view;
//        if(presenter==null){
//            presenter = getPresenter();
//        }
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
