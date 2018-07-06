package com.example.zer.weiyingdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.view.fragment.fourFragment;
import com.example.zer.weiyingdemo.view.fragment.oneFragment;
import com.example.zer.weiyingdemo.view.fragment.threeFragment;
import com.example.zer.weiyingdemo.view.fragment.twoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottom_tabbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_tabbar = findViewById(R.id.bottom_tabbar);
        bottom_tabbar.init(getSupportFragmentManager())
                .setImgSize(50, 50)//设置ICON图片的尺寸
                .setFontSize(8)//设置文字的尺寸
                .setTabPadding(10,6,10)
                .addTabItem("精选", R.drawable.found_select, R.drawable.found, oneFragment.class)
                .addTabItem("专题", R.drawable.special_select, R.drawable.special, twoFragment.class)
                .addTabItem("发现", R.drawable.fancy_select, R.drawable.fancy, threeFragment.class)
                .addTabItem("我的", R.drawable.my_select, R.drawable.my, fourFragment.class)
                .setTabBarBackgroundResource(R.drawable.bottom_bg)
                .setCurrentTab(0);
    }
    
}
