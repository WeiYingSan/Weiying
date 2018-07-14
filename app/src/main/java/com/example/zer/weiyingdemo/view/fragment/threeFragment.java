package com.example.zer.weiyingdemo.view.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zer.weiyingdemo.CardConfig;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.SwipeCardCallBack;
import com.example.zer.weiyingdemo.SwipeCardLayoutManager;
import com.example.zer.weiyingdemo.view.adapter.UniversalAdapter;
import com.example.zer.weiyingdemo.model.bean.DiscoverBean;
import com.example.zer.weiyingdemo.presenter.DiscoverPresenter;
import com.example.zer.weiyingdemo.view.interfaces.IDiscoverView;
import java.util.List;
import java.util.Random;

public class threeFragment extends BaseFragment<DiscoverPresenter> implements IDiscoverView {
    private RecyclerView mActivity_review;
    private UniversalAdapter mAdatper;
    private TextView discover_huan;
    private DiscoverPresenter discoverPresenter;
    private List<DiscoverBean.RetBean.ListBean> list;
    int page=0;
    private TextView discover_noitem;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                mAdatper.notifyDataSetChanged();
                CardConfig.initConfig(getActivity());
                ItemTouchHelper.Callback callback=new SwipeCardCallBack(list,mAdatper,mActivity_review);
                ItemTouchHelper helper=new ItemTouchHelper(callback);
                helper.attachToRecyclerView(mActivity_review);
            }
        }
    };

    @Override
    protected int getChildFragment() {
        return R.layout.threefragment;
    }

    @Override
    protected void initView(View view) {
        discoverPresenter=getPresenter();
        discoverPresenter.attachView(this);
        discoverPresenter.getPDiscover("402834815584e463015584e539330016",page+"");

        mActivity_review = view.findViewById(R.id.activity_review);
        discover_noitem = view.findViewById(R.id.discover_noitem);
        discover_huan = view.findViewById(R.id.discover_huan);

        SwipeCardLayoutManager swmanamger = new SwipeCardLayoutManager(getActivity());
        mActivity_review.setLayoutManager(swmanamger);
    }

    protected void initData() {

    }

    @Override
    protected DiscoverPresenter getPresenter() {
        return new DiscoverPresenter();
    }

    @Override
    public void onSuccess(DiscoverBean discoverBean) {
        list = discoverBean.getRet().getList();
        if(list==null && list.isEmpty()){
            discover_noitem.setVisibility(View.VISIBLE);
        }
        mAdatper = new UniversalAdapter(list, getActivity());
        mActivity_review.setAdapter(mAdatper);
        CardConfig.initConfig(getActivity());
        ItemTouchHelper.Callback callback=new SwipeCardCallBack(list,mAdatper,mActivity_review);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mActivity_review);

        discover_huan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //page++;
                int min=1;
                int max=9;
                Random random = new Random();
                int num = random.nextInt(max)%(max-min+1) + min;
                discoverPresenter.getPDiscover("402834815584e463015584e539330016",num+"");
                handler.sendEmptyMessage(0);
            }
        });
    }

    @Override
    public void onError(String s) {
        Log.e("tftf",s);
    }
}
