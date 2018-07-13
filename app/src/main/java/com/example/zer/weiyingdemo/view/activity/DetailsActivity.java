package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.zer.weiyingdemo.MyApp;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.db.ShouCangBeanDao;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.model.bean.ShouCangBean;
import com.example.zer.weiyingdemo.presenter.DetailsPresenter;
import com.example.zer.weiyingdemo.view.fragment.BriefingSesstionFragment;
import com.example.zer.weiyingdemo.view.fragment.CommentFragment;
import com.example.zer.weiyingdemo.view.interfaces.DetailsInterV;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsInterV {

    private TextView details_title;
    private ImageView details_back;
    private ImageView details_xing;
    private ViewPager details_viewpager;
    private List<String> list=new ArrayList<>();
    private TabLayout details_tablelayout;
    ArrayList<String> titleList=new ArrayList<>();
    ArrayList<Fragment> fragmentList=new ArrayList<>();
    private BriefingSesstionFragment briefingSesstionFragment;
    private CommentFragment commentFragment;
    private String mediaId;
    private JCVideoPlayer videocontroller1;
    private ShouCangBeanDao shouCangBeanDao;

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    int getChildView() {
        return R.layout.activity_details;
    }

    @Override
    void initView(){

        //找控件
        findId();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        mediaId = bundle.getString("mediaId", "");
        presenter.toM(mediaId);

    }

    private void findId() {
        details_title = findViewById(R.id.details_title);
        details_back = findViewById(R.id.details_back);
        details_xing = findViewById(R.id.details_xing);
        details_tablelayout = findViewById(R.id.details_tablelayout);
        details_viewpager = findViewById(R.id.details_viewpager);
        videocontroller1 = findViewById(R.id.videocontroller1);
    }

    @Override
    void initData() {
        //GrenDao初始化
        if(shouCangBeanDao==null){
            shouCangBeanDao = MyApp.instances.getDaoSession().getShouCangBeanDao();
        }
    }

    private void shoucanglistenner(final String id, final String pic, final String title) {
        details_xing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details_xing.setClickable(false);
                List<ShouCangBean> shouCangBeans = shouCangBeanDao.loadAll();
                Log.d("TAG", "onClick: 收藏数据库内容数量"+shouCangBeans.size());
                int j=0;
                for(int i=0;i<shouCangBeans.size();i++){
                    String url = shouCangBeans.get(i).getUrl();
                    if(url.equals(id)){
                        j=1;
                        break;
                    }
                }
                if(j==0){
                    ShouCangBean shouCangBean = new ShouCangBean();
                    shouCangBean.setPic(pic);
                    shouCangBean.setTitle(title);
                    shouCangBean.setUrl(id);
                    shouCangBeanDao.insert(shouCangBean);
                }
                details_xing.setClickable(true);
            }
        });
    }

    //关联Tablayout
    private void tablayoutdata(DetailsBean.RetBean v) {
        videocontroller1.setUp(v.getHDURL(),v.getTitle());
        Log.d("TAG", "tablayoutdata: 封面"+Uri.parse(v.getPic()));
        //jiecao/jiaozi设置封面
        Picasso.with(this).load(v.getPic()).into(videocontroller1.ivThumb);
        details_title.setText(v.getTitle()+"");
        titleList.add("简介");
        titleList.add("评论");
        briefingSesstionFragment = new BriefingSesstionFragment();
        briefingSesstionFragment.setData(v);
        commentFragment = new CommentFragment();
        commentFragment.setMediaId(mediaId);
        fragmentList.add(briefingSesstionFragment);
        fragmentList.add(commentFragment);
        //适配器
        details_viewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        details_tablelayout.setTabMode(TabLayout.MODE_FIXED);
        //关联
        details_tablelayout.setupWithViewPager(details_viewpager);
        //收藏监听
        shoucanglistenner(v.getDataID()+"",v.getPic(),v.getTitle()+"");
    }


    @Override
    DetailsPresenter setPresenter() {
        return new DetailsPresenter(this);
    }
    @Override
    public void detailsinterv(DetailsBean.RetBean v) {
        Log.d("TAG", "detailsinterv: 详情请求回来的数据" + v.getDirector());
        tablayoutdata(v);
        //        DetailsBean detailsBean = new DetailsBean();
//        detailsBean.setRet(v);
//        EventBus.getDefault().postSticky(detailsBean);
    }
    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            if(fragmentList!=null){
                return fragmentList.size();
            }else {
                return 0;
            }
        }

        //一定要重写这个返回标题的方法;

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

}
