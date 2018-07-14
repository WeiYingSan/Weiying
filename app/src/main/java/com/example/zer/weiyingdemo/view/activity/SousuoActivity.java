package com.example.zer.weiyingdemo.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zer.weiyingdemo.MyApp;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.db.LishiBeanDao;
import com.example.zer.weiyingdemo.model.bean.LishiBean;
import com.example.zer.weiyingdemo.view.adapter.SouSuoLiShiAdapter;
import com.example.zer.weiyingdemo.view.interfaces.SetEditInterfaceV;

import java.util.List;

public class SousuoActivity extends AppCompatActivity implements SetEditInterfaceV{

    private EditText sousuo_edit;
    private RecyclerView sousuo_lishi_recy;
    private TextView sousuo_text;
    private LishiBeanDao lishiBeanDao;
    private SouSuoLiShiAdapter souSuoLiShiAdapter;
    private List<LishiBean> lishiBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setContentView(R.layout.activity_sousuo);

        findId();
        //获取数据库
        getGrenDaoData();
        //查询数据库搜索历史赋值RecyClerView
        setLiShiRecyClerViewData();
        //搜索监听
        sousuolistenner();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&&resultCode==12){
            String lishiback = data.getStringExtra("lishiback");
            List<LishiBean> lishiBeans = lishiBeanDao.loadAll();
            int j=0;
            for(int i=0;i<lishiBeans.size();i++){
                if(lishiBeans.get(i).getName().equals(lishiback)){
                    j=1;
                    break;
                }
            }
            if(j==0){
                LishiBean lishiBean = new LishiBean();
                lishiBean.setName(lishiback);
                lishiBeanDao.insert(lishiBean);
            }
            setLiShiRecyClerViewData();
        }
    }


    private void sousuolistenner() {
        sousuo_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = sousuo_edit.getText().toString();
                if(s.equals("取消")){
                    finish();
                }else{
                    Intent intent = new Intent(SousuoActivity.this,SousuoToActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("editdata",s);
                    intent.putExtra("bundle",bundle);
                    startActivityForResult(intent,10);
                }
            }
        });
        sousuo_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TAG", "onTextChanged: "+s+"-"+start+"-"+before+"-"+count);
                 if(s.length()>0){
                     sousuo_text.setText("搜索");
                 }else{
                     sousuo_text.setText("取消");
                 }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void setLiShiRecyClerViewData() {
        if(lishiBeans!=null){
            lishiBeans.clear();
        }
        lishiBeans = lishiBeanDao.loadAll();
        if(souSuoLiShiAdapter==null){
            souSuoLiShiAdapter = new SouSuoLiShiAdapter(this);
            souSuoLiShiAdapter.setInterface(SousuoActivity.this);
            souSuoLiShiAdapter.setList(lishiBeans);
            sousuo_lishi_recy.setLayoutManager(new LinearLayoutManager(this));
            sousuo_lishi_recy.setAdapter(souSuoLiShiAdapter);
        }else{
            souSuoLiShiAdapter.setList(lishiBeans);
            souSuoLiShiAdapter.notifyDataSetChanged();
        }

    }

    private void getGrenDaoData() {
        if(lishiBeanDao==null){
            lishiBeanDao = MyApp.getInstances().getDaoSession().getLishiBeanDao();
        }
        if(lishiBeanDao!=null){

        }
    }

    private void findId() {
        sousuo_edit = findViewById(R.id.sousuo_edit);
        sousuo_lishi_recy = findViewById(R.id.sousuo_lishi_recy);
        sousuo_text = findViewById(R.id.sousuo_text);
    }

    @Override
    public void setEdit(String name) {
        sousuo_edit.setText(name+"");
    }
}
