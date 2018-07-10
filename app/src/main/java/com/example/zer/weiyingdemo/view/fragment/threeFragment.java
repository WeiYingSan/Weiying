package com.example.zer.weiyingdemo.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zer.weiyingdemo.CardConfig;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.SwipeCardBean;
import com.example.zer.weiyingdemo.SwipeCardCallBack;
import com.example.zer.weiyingdemo.SwipeCardLayoutManager;
import com.example.zer.weiyingdemo.UniversalAdapter;

import java.util.ArrayList;

public class threeFragment extends Fragment {
    private RecyclerView mActivity_review;
    private UniversalAdapter mAdatper;
    private ArrayList<SwipeCardBean> mList;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.threefragment, null);

        initView();
        initData();
        setData();

        return view;
    }

    private void initView() {
        mList = new ArrayList<>();
        mActivity_review = view.findViewById(R.id.activity_review);

    }

    private void initData() {
        /**这里的图片就上网百度了8张。本人比较懒就用本地图片代替。
         当然你要有现成的接口也可以网络加载解析。*/
        int[] intimage = {R.drawable.c, R.drawable.d, R.drawable.e,      R.drawable.f,
                R.drawable.g, R.drawable.a, R.drawable.b};
        for (int i = 0; i < 7; i++) {
            SwipeCardBean swpe = new SwipeCardBean();
            swpe.resoutimage = intimage[i];
            swpe.title = "美丽" + i;
            mList.add(swpe);
        }
    }
    private void setData() {
        SwipeCardLayoutManager swmanamger = new SwipeCardLayoutManager(getActivity());
        mActivity_review.setLayoutManager(swmanamger);
        mAdatper = new UniversalAdapter(mList, getActivity());
        mActivity_review.setAdapter(mAdatper);
        CardConfig.initConfig(getActivity());
        ItemTouchHelper.Callback callback=new SwipeCardCallBack(mList,mAdatper,mActivity_review);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mActivity_review);
    }
}
