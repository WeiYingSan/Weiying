package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zer.weiyingdemo.R;

public class SousuoToActivity extends AppCompatActivity {

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
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
