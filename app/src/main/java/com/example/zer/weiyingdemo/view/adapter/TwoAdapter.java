package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<ShouYeBean.RetBean.ListBean> list;
    public TwoAdapter(Context context) {
        this.context = context;
    }

    public void setTwo(List<ShouYeBean.RetBean.ListBean> list){
        this.list = list;
    }
    
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.two_item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.two_item_text.setText(list.get(position).getTitle());
        if (list.get(position).getChildList().get(0).getPic().equals("")){
            String pic = list.get(3).getChildList().get(0).getPic();
            Glide.with(context).load(pic).into(viewHolder.two_item_img);
        }else{
            String pic1 = list.get(position).getChildList().get(0).getPic();
            Glide.with(context).load(pic1).into(viewHolder.two_item_img); 
        }
        if (list.get(position).getTitle().equals("")){
            viewHolder.two_item_text.setText("默认精选");
        }else{
            viewHolder.two_item_text.setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView two_item_img;
        private final TextView two_item_text;

        public ViewHolder(View itemView) {
            super(itemView);
            two_item_img = itemView.findViewById(R.id.two_item_img);
            two_item_text = itemView.findViewById(R.id.two_item_text);
        }
    }
}
