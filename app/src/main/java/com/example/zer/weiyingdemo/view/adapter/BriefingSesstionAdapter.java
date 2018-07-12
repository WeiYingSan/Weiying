package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.DetailsBean;

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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         BirefingSesstionViewHolder bir= (BirefingSesstionViewHolder) holder;
         bir.title.setText(childList.get(position).getTitle()+"");
        Glide.with(context).load(childList.get(position).getPic()).into(bir.img);
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
