package com.example.zer.weiyingdemo.view.activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zer.weiyingdemo.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("aaaa", "onCreate: &&&"+"zhengenru");
        Log.e("aaaa", "onCreate: &&&"+"wangtianqi");
        Log.e("aaaa", "onCreate: &&&"+"lihaofan");
        Handler handler = new Handler();
        handler.sendEmptyMessage(0);
    }
    
}
