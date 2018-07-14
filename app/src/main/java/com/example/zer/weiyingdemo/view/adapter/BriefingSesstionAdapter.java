package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;
import com.example.zer.weiyingdemo.view.activity.DetailsActivity;

import java.util.List;

public class BriefingSesstionAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<DetailsBean.RetBean.ListBean.ChildListBean> childList;

    public BriefingSesstionAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<DetailsBean.RetBean.ListBean.ChildListBean> childList){
        this.childList=childList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.briefingsesstion_recy_layout,null);
        BirefingSesstionViewHolder birefingSesstionViewHolder = new BirefingSesstionViewHolder(view);
        return birefingSesstionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
         BirefingSesstionViewHolder bir= (BirefingSesstionViewHolder) holder;
         bir.title.setText(childList.get(position).getTitle()+"");
        Glide.with(context).load(childList.get(position).getPic()).into(bir.img);
        bir.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                Bundle bundle = new Bundle();
                String dataId = childList.get(position).getDataId();
                Log.d("aaaa", "onClick: %%%%"+dataId);
                bundle.putString("mediaId",dataId);
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(childList!=null){
            return childList.size();
        }else{
            return 0;
        }
    }

    public class BirefingSesstionViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;
        public BirefingSesstionViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.briefing_recy_img);
            title=itemView.findViewById(R.id.briefing_recy_title);
        }
    }

}
