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
import com.example.zer.weiyingdemo.model.bean.FuzzyQueryBean;
import com.example.zer.weiyingdemo.model.bean.ShouCangBean;

import java.util.List;

public class FuzzyAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<FuzzyQueryBean.RetBean.ListBean> list;
    public FuzzyAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<FuzzyQueryBean.RetBean.ListBean> list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shoucang_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.shoucang_item_text.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(viewHolder.shoucang_item_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView shoucang_item_text;
        private final ImageView shoucang_item_img;

        public ViewHolder(View itemView) {
            super(itemView);
            shoucang_item_img = itemView.findViewById(R.id.shoucang_item_img);
            shoucang_item_text = itemView.findViewById(R.id.shoucang_item_text);
        }
    }
}
