package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.FuliBean;
import com.example.zer.weiyingdemo.view.activity.FuliActivity;

import java.util.List;

public class FuliAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<FuliBean.ResultsBean> list;
    public FuliAdapter(Context context, List<FuliBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fuli_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ViewHolder viewHolder = (ViewHolder) holder;
        ViewGroup.LayoutParams params = viewHolder.fuli_img.getLayoutParams();
        viewHolder.fuli_img.setLayoutParams(params);
        Glide.with(context).load(list.get(position).getUrl()).into(viewHolder.fuli_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView fuli_img;

        public ViewHolder(View itemView) {
            super(itemView);
            fuli_img = itemView.findViewById(R.id.fuli_img);
        }
    }
}
