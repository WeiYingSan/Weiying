package com.example.zer.weiyingdemo.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.model.bean.CommentBean;
import com.example.zer.weiyingdemo.utils.GlideRound;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<CommentBean.RetBean.ListBean> list;
    public CommentAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<CommentBean.RetBean.ListBean> list){
        this.list=list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.fragment_comment_recy_layout,null);
        CommentViewHolder commentViewHolder=new CommentViewHolder(view);
        return commentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommentViewHolder commentViewHolder= (CommentViewHolder) holder;
        commentViewHolder.count.setText(list.get(position).getLikeNum()+"");
        GlideRound.setGlideRound2(context,list.get(position).getUserPic()+"",commentViewHolder.tou);
        commentViewHolder.detail.setText(list.get(position).getMsg()+"");
        commentViewHolder.time.setText(list.get(position).getTime()+"");
        commentViewHolder.title.setText(list.get(position).getPhoneNumber()+"");
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }else{
            return 0;
        }
    }
    class CommentViewHolder extends RecyclerView.ViewHolder{
        private ImageView tou;
        private TextView title;
        private TextView time;
        private TextView detail;
        private TextView count;
        public CommentViewHolder(View itemView) {
            super(itemView);
            tou=itemView.findViewById(R.id.comment_recy_tou);
            title=itemView.findViewById(R.id.comment_recy_name);
            time=itemView.findViewById(R.id.comment_recy_time);
            detail=itemView.findViewById(R.id.comment_recy_details);
            count=itemView.findViewById(R.id.like_count);
        }
    }
}
