package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.FuzzyQueryBean;
import com.example.zer.weiyingdemo.model.http.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

        //网络请求
        queryinternet(editdata);
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
                if(value.getCode().equals(200)){
                   // value.getRet().
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
