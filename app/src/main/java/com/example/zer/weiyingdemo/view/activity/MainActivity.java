package com.example.zer.weiyingdemo.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.utils.GlideRound;
import com.example.zer.weiyingdemo.view.fragment.fourFragment;
import com.example.zer.weiyingdemo.view.fragment.oneFragment;
import com.example.zer.weiyingdemo.view.fragment.threeFragment;
import com.example.zer.weiyingdemo.view.fragment.twoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ColorChooserDialog.ColorCallback{

    private BottomTabBar bottom_tabbar;
    private TextView include_title;
    private ImageView cela_tou;
    private TextView main_shoucang;
    private TextView main_xiazia;
    private TextView main_fuli;
    private TextView main_fenxiang;
    private TextView main_jianyi;
    private TextView main_shezhi;
    private TextView main_guanyu;
    private TextView main_zhuti;
    private RelativeLayout main_recycle;
    private LinearLayout main_line;
    private SharedPreferences user;

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
        user = getSharedPreferences("User", MODE_PRIVATE);
        //找控件
        findId();
        //侧拉头像赋值
        ceLaTouData();
        bottom_tabbar.init(getSupportFragmentManager())
                .setImgSize(25, 25)//设置ICON图片的尺寸
                .setFontSize(10)//设置文字的尺寸
                .setTabPadding(4,0,4   )
                .addTabItem("精选", R.drawable.found_select, R.drawable.found, oneFragment.class)
                .addTabItem("专题", R.drawable.special_select, R.drawable.special, twoFragment.class)
                .addTabItem("发现", R.drawable.fancy_select, R.drawable.fancy, threeFragment.class)
                .addTabItem("我的", R.drawable.my_select, R.drawable.my, fourFragment.class)
                .setTabBarBackgroundResource(R.drawable.a)
                .setCurrentTab(0);
    }
    
    private void ceLaTouData() {
        GlideRound.setGlideRound(this,R.drawable.photo,cela_tou);
    }

    private void findId() {
        bottom_tabbar = findViewById(R.id.bottom_tabbar);
        include_title = findViewById(R.id.include_title);
        cela_tou = findViewById(R.id.cela_tou);
        main_shoucang = findViewById(R.id.main_shoucang);
        main_xiazia = findViewById(R.id.main_xiazia);
        main_fuli = findViewById(R.id.main_fuli);
        main_fenxiang = findViewById(R.id.main_fenxiang);
        main_jianyi = findViewById(R.id.main_jianyi);
        main_shezhi = findViewById(R.id.main_shezhi);
        main_guanyu = findViewById(R.id.main_guanyu);
        main_zhuti = findViewById(R.id.main_zhuti);
        main_recycle = findViewById(R.id.main_recycle);
        main_line = findViewById(R.id.main_line);
        main_shoucang.setOnClickListener(this);
        main_xiazia.setOnClickListener(this);
        main_fuli.setOnClickListener(this);
        main_fenxiang.setOnClickListener(this);
        main_jianyi.setOnClickListener(this);
        main_shezhi.setOnClickListener(this);
        main_guanyu.setOnClickListener(this);
        main_zhuti.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_shoucang:
                tusi();
                break;
            case R.id.main_xiazia:
                tusi();
                break;
            case R.id.main_fuli:
                Intent intent1 = new Intent(this, FuliActivity.class);
                startActivity(intent1);
                break;
            case R.id.main_fenxiang:
                tusi();
                break;
            case R.id.main_jianyi:
                tusi();
                break;
            case R.id.main_shezhi:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.main_guanyu:
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("关于我们")
                        .setMessage("博客:jianjeufo")
                        .setMessage("Gihubt:ghost")
                        .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .create();
                dialog.show();
                break;
            case R.id.main_zhuti:
                        //颜色的数组
                int[] primary = new int[]{
                        Color.parseColor("#F44336"),
                        Color.parseColor("#FF0000"),
                        Color.parseColor("#FFFF00"),
                        Color.parseColor("#00FF00"),
                        Color.parseColor("#0000FF"),
                        Color.parseColor("#00FFFF"),
                        Color.parseColor("#FF00FF"),
                        Color.parseColor("#ff6600"),
                        Color.parseColor("#ff9966"),
                        Color.parseColor("#cc0000"),
                        Color.parseColor("#993399"),
                        Color.parseColor("#cc6699"),
                        Color.parseColor("#ffccff"),
                        Color.parseColor("#cc66cc"),
                        Color.parseColor("#cc33cc"),
                        Color.parseColor("#00ff33"),
                        Color.parseColor("#3399cc"),
                        Color.parseColor("#0066ff"),
                        Color.parseColor("#0099ff"),
                        Color.parseColor("#00cc99"),
                };
                //有些按钮是系统默认的
                new ColorChooserDialog.Builder(MainActivity.this, R.string.color_palette)
                        .accentMode(true)//
                        .customColors(primary, null)//两个颜色数组
                        .dynamicButtonColor(true)//动态按钮颜色
                        .customButton(0)//设置颜色不显示
                        .cancelButton(R.string.cancle)
                        .doneButton(R.string.done)
                        .show(MainActivity.this);//传入上下文
                break;
            
        }
    }

    private void tusi() {
        Toast.makeText(this, "程序猿正在努力研发中...", Toast.LENGTH_SHORT).show();
    }

    //颜色选择改变事件
    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {
        main_recycle.setBackgroundColor(selectedColor);
        main_line.setBackgroundColor(selectedColor);

        user.edit().putInt("color",selectedColor).commit();
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {
    }
    
}
