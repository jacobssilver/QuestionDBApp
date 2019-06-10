package com.example.QuestionDBApp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ClassListActivity extends AppCompatActivity {

    private List<Exam> classlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        getSupportActionBar().hide();

        //back
        ImageView back = findViewById(R.id.back_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initclasslist();
        //ClassList
        RecyclerView recyclerView = findViewById(R.id.class_List_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ClassAdapter classAdapter = new ClassAdapter(this,classlist);
        recyclerView.setAdapter(classAdapter);

    }

    public void initclasslist(){
        Exam exam = new Exam("计算机网络",R.drawable.computer);
        classlist.add(exam);
        classlist.add(exam);
        classlist.add(exam);
        classlist.add(exam);
        classlist.add(exam);
        classlist.add(exam);
        classlist.add(exam);
        classlist.add(exam);
    }
    public class ClassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<Exam> ClassList;
        private Context context;

        public ClassAdapter(Context context, List<Exam> ClassList){
            this.ClassList = ClassList;
            this.context=context;
        }

        public class MyHolder extends RecyclerView.ViewHolder{
            ImageView img;
            TextView name;

            public MyHolder(View view){
                super(view);
                img = view.findViewById(R.id.class_img);
                name =  view.findViewById(R.id.class_name);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ClassActivity.class);
                        startActivity(intent);
                    }
                });
            }

        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.class_list_item,viewGroup,false);
            ClassAdapter.MyHolder holder;
            holder = new ClassAdapter.MyHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyHolder classHolder = (MyHolder) viewHolder;
            Exam exam = classlist.get(i);
            classHolder.img.setImageResource(exam.getExam_imageid());
            classHolder.name.setText(exam.getExam_name());
        }

        @Override
        public int getItemCount() {
            return classlist.size();
        }
    }
}
