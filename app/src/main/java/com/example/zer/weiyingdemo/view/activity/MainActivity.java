package com.example.zer.weiyingdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.view.fragment.fourFragment;
import com.example.zer.weiyingdemo.view.fragment.oneFragment;
import com.example.zer.weiyingdemo.view.fragment.threeFragment;
import com.example.zer.weiyingdemo.view.fragment.twoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottom_tabbar;
    private TextView include_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_tabbar = findViewById(R.id.bottom_tabbar);
        include_title = findViewById(R.id.include_title);
        bottom_tabbar.init(getSupportFragmentManager())
                .setImgSize(30, 30)//设置ICON图片的尺寸
                .setFontSize(13)//设置文字的尺寸
                .setTabPadding(10,6,0)
                .addTabItem("精选", R.drawable.found_select, R.drawable.found, oneFragment.class)
                .addTabItem("专题", R.drawable.special_select, R.drawable.special, twoFragment.class)
                .addTabItem("发现", R.drawable.fancy_select, R.drawable.fancy, threeFragment.class)
                .addTabItem("我的", R.drawable.my_select, R.drawable.my, fourFragment.class)
                .setTabBarBackgroundResource(R.drawable.aaa)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        switch (position){
                            case 0:
                                include_title.setText(name);
                                break;
                            case 1:
                                include_title.setText(name);
                                break;
                            case 2:
                                include_title.setText(name);
                                break;
                            case 3:
                                include_title.setText(name);
                                break;
                        }
                    }
                })
                .setCurrentTab(0);
    }
    
}
