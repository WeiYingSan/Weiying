package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.DiscoverBean;
import com.example.zer.weiyingdemo.view.activity.DetailsActivity;
import java.util.List;

public class UniversalAdapter extends RecyclerView.Adapter<UniversalAdapter.UniversalViewHolder> {
    List<DiscoverBean.RetBean.ListBean> list;
    Context context;
    public UniversalAdapter(List<DiscoverBean.RetBean.ListBean> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @Override
    public UniversalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_item, null);
        UniversalViewHolder holder = new UniversalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UniversalViewHolder holder, final int position) {
        UniversalViewHolder holder1=holder;
        holder1.disadapter_name.setText(""+list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(holder1.disadapter_img);
        holder1.disadapter_text.setText(list.get(position).getDescription());

        //适配器中的条目点击监听
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
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
        /*return mData == null ? 0 : mData.size();*/
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    public class UniversalViewHolder extends RecyclerView.ViewHolder {
        private final TextView disadapter_name;
        public TextView disadapter_text;
        public ImageView disadapter_img;

        public UniversalViewHolder(View itemView) {
            super(itemView);
            disadapter_name = itemView.findViewById(R.id.disadapter_name);
            disadapter_img=itemView.findViewById(R.id.disadapter_img);
            disadapter_text=itemView.findViewById(R.id.disadapter_text);
        }
    }
}
