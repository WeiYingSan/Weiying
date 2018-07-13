package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.PinDaoBean;
import com.example.zer.weiyingdemo.view.activity.DetailsActivity;
import com.example.zer.weiyingdemo.view.activity.DianYingActivity;

import java.util.List;

public class PindaoAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<PinDaoBean.RetBean.ListBean> list;
    public PindaoAdapter(Context context, List<PinDaoBean.RetBean.ListBean> beanList) {
        this.context =context;
        this.list = beanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pindao_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.pindao_text.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(viewHolder.pindao_img);
        viewHolder.pindao_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                Bundle bundle = new Bundle();
                String dataId = list.get(position).getDataId();
                Log.d("aaaa", "onClick: %%%%"+dataId);
                bundle.putString("mediaId",dataId);
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView pindao_img;
        private final TextView pindao_text;

        public ViewHolder(View itemView) {
            super(itemView);
            pindao_img = itemView.findViewById(R.id.pindao_img);
            pindao_text = itemView.findViewById(R.id.pindao_text);
        }
    }
}
