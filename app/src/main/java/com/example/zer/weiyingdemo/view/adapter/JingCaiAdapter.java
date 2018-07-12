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
import com.example.zer.weiyingdemo.model.bean.ShouYeBean;
import com.example.zer.weiyingdemo.view.activity.DetailsActivity;
import com.example.zer.weiyingdemo.view.fragment.oneFragment;

import java.util.List;

public class JingCaiAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<ShouYeBean.RetBean.ListBean.ChildListBean> list;

    public JingCaiAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<ShouYeBean.RetBean.ListBean.ChildListBean> list){
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.jingcairecylayout,null);
        JingCaiViewHolder jingCaiViewHolder = new JingCaiViewHolder(view);
        return jingCaiViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
           JingCaiViewHolder jingCaiViewHolder= (JingCaiViewHolder) holder;
           jingCaiViewHolder.textView.setText(list.get(position).getTitle());
           Glide.with(context).load(list.get(position).getPic()).into(jingCaiViewHolder.imageView);

        jingCaiViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        if(list!=null){
            return list.size();
        }else{
            return 0;
        }
    }

    public class JingCaiViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public JingCaiViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.jingcairecy_img);
            textView=itemView.findViewById(R.id.jingcairecy_text);
        }
    }

}
