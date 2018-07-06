package com.example.zer.weiyingdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.zer.weiyingdemo.R;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Log.e("aaa", "onCreate: "+"zer");
        Log.e("aaa", "onCreate: "+"zer1");
        Log.e("aaa", "onCreate: "+"zer2");
        Log.e("aaa", "onCreate: "+"zer3");
    }
    
}
