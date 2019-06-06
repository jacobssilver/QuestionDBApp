package com.example.QuestionDBApp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.QuestionDBApp.R;

import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Exam> examList;
    private Context context;
    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView examImage;
        TextView examName;

        public MyHolder(View view){
            super(view);
            examImage =  view.findViewById(R.id.exam_itemimg);
            examName = view.findViewById(R.id.exam_itemtext);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ClassActivity.class);
                    context.startActivity(intent);
                }
            });
        }

    }
    public ExamAdapter(Context context,List<Exam> examlist)
    {
        this.context = context;
        this.examList = examlist;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_item_layout,parent,false);
        MyHolder holder;
        holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder examHolder = (MyHolder) viewHolder;
        Exam exam = examList.get(i);
        examHolder.examImage.setImageResource(exam.getExam_imageid());
        examHolder.examName.setText(exam.getExam_name());

    }

    @Override
    public int getItemCount(){
        return examList.size();
    }
}
