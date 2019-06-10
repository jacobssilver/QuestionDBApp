package com.example.QuestionDBApp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.QuestionDBApp.fragment.FragmentQ1;
import com.example.QuestionDBApp.fragment.FragmentQ2;
import com.example.QuestionDBApp.fragment.FragmentQ3;
import com.example.QuestionDBApp.fragment.FragmentQ4;
import com.example.QuestionDBApp.R;

import java.util.ArrayList;
import java.util.List;

public class ClassActivity extends AppCompatActivity {

    private List<String> testList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        getSupportActionBar().hide();
        //back
        ImageView back = findViewById(R.id.back_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //testlist
        initTestList();
        RecyclerView recyclerView = this.findViewById(R.id.test_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerviewAdapter testAdapter = new RecyclerviewAdapter(this,testList);
        recyclerView.setAdapter(testAdapter);

    }
    public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

        private Context context;
        private List<String> data;

        public RecyclerviewAdapter(Context context,List<String> data){
            this.context = context;
            this.data = data;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.test_item_layout,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.name.setText(data.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ClassActivity.this, TestActivity.class);
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {

            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            private TextView name;

            public ViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.exam_name);

            }
        }
    }
    public void initTestList(){
        testList.add("计算机网络");
        testList.add("计算机网络");
        testList.add("计算机网络");
        testList.add("计算机网络");
        testList.add("计算机网络");
        testList.add("计算机网络");
    }

}
