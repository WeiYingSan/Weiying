package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.LishiBean;
import com.example.zer.weiyingdemo.view.activity.SousuoActivity;

import java.util.List;

public class SouSuoLiShiAdapter extends RecyclerView.Adapter{
   private Context context;
   private List<LishiBean> list;

    public SouSuoLiShiAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<LishiBean> list){
        if(this.list!=null){
            this.list.clear();
        }
        this.list=list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.lishi_recy_layout,null);
        SousuoLiShiViewHolder sousuoLiShiViewHolder = new SousuoLiShiViewHolder(view);
        return sousuoLiShiViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SousuoLiShiViewHolder sousuoLiShiViewHolder = (SousuoLiShiViewHolder) holder;
        sousuoLiShiViewHolder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if(list==null){
            return 0;
        }else{
            return list.size();
        }
    }
    class SousuoLiShiViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public SousuoLiShiViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.sousuo_lishi_recy_text);
        }
    }
}
