package com.example.zer.weiyingdemo.view.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.zer.weiyingdemo.R;

import java.lang.reflect.Field;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout setting_relative1;
    private ImageView setting_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        setContentView(R.layout.activity_setting);

        initView();
    }

    private void initView() {
        setting_back = findViewById(R.id.setting_back);
        setting_back.setOnClickListener(this);
        setting_relative1 = findViewById(R.id.setting_relative1);
        setting_relative1.setOnClickListener(this);
        RelativeLayout setting_relative3 = findViewById(R.id.setting_relative3);
        setting_relative3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_back:
                finish();
                break;
            case R.id.setting_relative1:
                new AlertDialog.Builder(this)
                        .setTitle("发现一个看片神器")
                        .setMessage("https://github.com/GeekGhost/Ghost")
                        .setNegativeButton("复制", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SettingActivity.this,"已复制到剪切板",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .create().show();
                break;
            case R.id.setting_relative3:
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
                // 在dialog执行show之后才能来设置
                TextView tvMsg = (TextView) dialog.findViewById(android.R.id.message);
                tvMsg.setTextSize(16);
                tvMsg.setTextColor(Color.parseColor("#FF0000"));

                dialog.getButton(dialog.BUTTON_NEGATIVE).setTextSize(16);
                dialog.getButton(dialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#FF0000"));
                try {
                    Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
                    mAlert.setAccessible(true);
                    Object alertController = mAlert.get(dialog);

                    Field mTitleView = alertController.getClass().getDeclaredField("mTitleView");
                    mTitleView.setAccessible(true);

                    TextView tvTitle = (TextView) mTitleView.get(alertController);
                    if (null != tvTitle) {
                        tvTitle.setTextSize(16);
                        tvTitle.setTextColor(Color.parseColor("#000000"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
