package com.example.zer.weiyingdemo.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.view.fragment.fourFragment;
import com.example.zer.weiyingdemo.view.fragment.oneFragment;
import com.example.zer.weiyingdemo.view.fragment.threeFragment;
import com.example.zer.weiyingdemo.view.fragment.twoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottom_tabbar;
    private TextView include_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_tabbar = findViewById(R.id.bottom_tabbar);
        include_title = findViewById(R.id.include_title);
        bottom_tabbar.init(getSupportFragmentManager())
                .setImgSize(25, 25)//设置ICON图片的尺寸
                .setFontSize(10)//设置文字的尺寸
                .setTabPadding(4,0,4   )
                .addTabItem("精选", R.drawable.found_select, R.drawable.found, oneFragment.class)
                .addTabItem("专题", R.drawable.special_select, R.drawable.special, twoFragment.class)
                .addTabItem("发现", R.drawable.fancy_select, R.drawable.fancy, threeFragment.class)
                .addTabItem("我的", R.drawable.my_select, R.drawable.my, fourFragment.class)
                .setTabBarBackgroundResource(R.drawable.a)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        switch (position){
                            case 0:
                                if (name.equals("精选")){
                                    include_title.setVisibility(View.GONE);
                                }
                                break;
                            case 1:
                                if (name.equals("专题")){
                                    include_title.setText(name);
                                    include_title.setVisibility(View.VISIBLE);
                                }
                                break;
                            case 2:
                                if (name.equals("发现")){
                                    include_title.setText(name);
                                    include_title.setVisibility(View.VISIBLE);
                                }
                                break;
                            case 3:
                                if (name.equals("我的")){
                                    include_title.setText(name);
                                    include_title.setVisibility(View.VISIBLE);
                                }
                                break;
                        }
                    }
                })
                .setCurrentTab(0);
    }
    
}
