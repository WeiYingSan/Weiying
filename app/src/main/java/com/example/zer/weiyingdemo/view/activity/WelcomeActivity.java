package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.zer.weiyingdemo.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity{
    private ImageView iv_welcome_bg;
    private SharedPreferences types;
    private SharedPreferences.Editor edit;
    private int count;

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
        types = getSharedPreferences("types", MODE_PRIVATE);
        edit = types.edit();
        count = types.getInt("count", 1);
        count++;
        count = count %5;
        edit.putInt("count", count);
        edit.commit();
        setContentView(R.layout.activity_welcome);
        iv_welcome_bg = findViewById(R.id.iv_welcome_bg);
        iv_welcome_bg.setImageResource(R.drawable.welcome);
        iv_welcome_bg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();

        switch (count){
            case 0:
                //iv_welcome_bg.setBackgroundResource(R.drawable.b);
                iv_welcome_bg.setImageResource(R.drawable.b);
            break;
            case 1:
              //  iv_welcome_bg.setBackgroundResource(R.drawable.c);
                iv_welcome_bg.setImageResource(R.drawable.c);
                break;
            case 2:
               // iv_welcome_bg.setBackgroundResource(R.drawable.d);
                iv_welcome_bg.setImageResource(R.drawable.d);
                break;
            case 3:
                //iv_welcome_bg.setBackgroundResource(R.drawable.e);
                iv_welcome_bg.setImageResource(R.drawable.e);
                break;
            case 4:
                //iv_welcome_bg.setBackgroundResource(R.drawable.f);
                iv_welcome_bg.setImageResource(R.drawable.f);
                break;
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
