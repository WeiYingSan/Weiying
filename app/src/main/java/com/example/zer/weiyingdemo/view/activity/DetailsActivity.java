package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import android.widget.TableLayout;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.presenter.DetailsPresenter;
import com.example.zer.weiyingdemo.view.fragment.BriefingSesstionFragment;
import com.example.zer.weiyingdemo.view.fragment.CommentFragment;
import com.example.zer.weiyingdemo.view.interfaces.DetailsInterV;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

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
        String mediaId = bundle.getString("mediaId", "");
        presenter.toM(mediaId);

    }

    private void findId() {
        details_title = findViewById(R.id.details_title);
        details_back = findViewById(R.id.details_back);
        details_xing = findViewById(R.id.details_xing);
        details_tablelayout = findViewById(R.id.details_tablelayout);
        details_viewpager = findViewById(R.id.details_viewpager);
}

    @Override
    void initData() {

    }
    //关联Tablayout
    private void tablayoutdata(DetailsBean.RetBean v) {
        titleList.add("热门");
        titleList.add("附近");
        briefingSesstionFragment = new BriefingSesstionFragment();
        briefingSesstionFragment.setData(v);
        commentFragment = new CommentFragment();
        fragmentList.add(briefingSesstionFragment);
        fragmentList.add(commentFragment);
        //适配器
        details_viewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        details_tablelayout.setTabMode(TabLayout.MODE_FIXED);
        //关联
        details_tablelayout.setupWithViewPager(details_viewpager);
    }


    @Override
    DetailsPresenter setPresenter() {
        return new DetailsPresenter(this);
    }
    @Override
    public void detailsinterv(DetailsBean.RetBean v) {
        Log.d("TAG", "detailsinterv: 详情请求回来的数据"+v.getDirector());
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
            return fragmentList.size();
        }

        //一定要重写这个返回标题的方法;

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

}
