package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.zer.weiyingdemo.R;

public class SousuoToActivity extends AppCompatActivity {

    private RecyclerView sousuoto_recycle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo_to);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        String editdata = bundle.getString("editdata");
        Intent intent1 = new Intent();
        intent1.putExtra("lishiback",editdata);
        setResult(12,intent1);
        //初始化控件
        sousuoto_recycle = findViewById(R.id.sousuoto_recycle);
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    
}
