package com.example.QuestionDBApp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.QuestionDBApp.R;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Forum> forumList;
    private Context context;
    public class MyHolder extends RecyclerView.ViewHolder{
        TextView problemTitle;
        TextView problemInfo;
        TextView problemCom;

        public MyHolder(View view){
            super(view);
            problemTitle =  view.findViewById(R.id.problem_title);
            problemInfo = view.findViewById(R.id.problem_info);
            problemCom = view.findViewById(R.id.problem_com);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CommentActivity.class);
                    context.startActivity(intent);
                }
            });
        }

    }
    public ForumAdapter(Context context,List<Forum> forumlist){

        this.forumList = forumlist;
        this.context=context;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forum_item_layout,parent,false);
        MyHolder holder;
        holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder forumHolder = (MyHolder) viewHolder;
        Forum forum = forumList.get(i);
        forumHolder.problemTitle.setText(forum.getProblemTitle());
        forumHolder.problemInfo.setText(forum.getProblemInfo());
        forumHolder.problemCom.setText(forum.getProblemCom());
    }

    @Override
    public int getItemCount(){
        return forumList.size();
    }
}

