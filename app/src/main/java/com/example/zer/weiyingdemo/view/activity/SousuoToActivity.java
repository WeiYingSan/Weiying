package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.FuzzyQueryBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;
import com.example.zer.weiyingdemo.view.adapter.FuzzyAdapter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SousuoToActivity extends AppCompatActivity {

    private List<FuzzyQueryBean.RetBean.ListBean> list;
    private FuzzyAdapter fuzzyAdapter;
    private RecyclerView sousuoto_recycle;

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
        setContentView(R.layout.activity_sousuo_to);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        String editdata = bundle.getString("editdata");
        Intent intent1 = new Intent();
        intent1.putExtra("lishiback",editdata);
        setResult(12,intent1);
        //找控件
        findId();
        //网络请求
        queryinternet(editdata);
    }

    private void findId() {
        sousuoto_recycle = findViewById(R.id.sousuoto_recycle);
    }

    private void queryinternet(String key) {
        RetrofitUtils.getInstance().getApi()
                .getVideoByKeyWord(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuzzyQueryBean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(FuzzyQueryBean value) {
                if(value.getMsg().equals("成功")){
                    if(fuzzyAdapter==null){
                        fuzzyAdapter = new FuzzyAdapter(SousuoToActivity.this);
                        fuzzyAdapter.setList(value.getRet().getList());
                        sousuoto_recycle.setLayoutManager(new GridLayoutManager(SousuoToActivity.this,3, LinearLayoutManager.VERTICAL,false));
                        sousuoto_recycle.setAdapter(fuzzyAdapter);
                    }else{
                        fuzzyAdapter.setList(value.getRet().getList());
                        fuzzyAdapter.notifyDataSetChanged();
                    }
                }else{
                    Toast.makeText(SousuoToActivity.this, "请求数据失败!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
