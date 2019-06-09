package com.example.QuestionDBApp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Comment> commentList;
    private Context context;

    public CommentAdapter(Context context, List<Comment> commentList){
        this.commentList=commentList;
        this.context=context;
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView content;
        TextView num;
        TextView date;

        public MyHolder(View view){
            super(view);
            img = view.findViewById(R.id.answer_img);
            name =  view.findViewById(R.id.answer_name);
            content = view.findViewById(R.id.answer_content);
            num = view.findViewById(R.id.answer_num);
            date = view.findViewById(R.id.answer_date);
        }

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item_layout,viewGroup,false);
        CommentAdapter.MyHolder holder;
        holder = new CommentAdapter.MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder commentHolder = (MyHolder) viewHolder;
        Comment comment = commentList.get(i);
        commentHolder.img.setImageResource(comment.getImg());
        commentHolder.name.setText(comment.getName());
        commentHolder.content.setText(comment.getContent());
        commentHolder.num.setText(comment.getNum());
        commentHolder.date.setText(comment.getDate());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
