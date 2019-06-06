package com.example.QuestionDBApp;

import android.content.Context;
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

    //fragment
    private FragmentQ1 fragment1;
    private FragmentQ2 fragment2;
    private FragmentQ3 fragment3;
    private FragmentQ4 fragment4;
    private Fragment[] fragments;
    private  int lastfragment=0;


    private List<String> testList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        getSupportActionBar().hide();
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
                    setContentView(R.layout.test_main);
                    //question
                    initfragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment1).show(fragment1).commit();
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
    public void onitemclick(View v){
        switch (v.getId()){
            case R.id.question_list:{
                Toast.makeText(ClassActivity.this,"you have clicked Button3",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.button1:{
                if(lastfragment!=0){
                    switchFragment(lastfragment,0);
                    lastfragment = 0;
                }
                break;
            }
            case R.id.button2:{
                if(lastfragment!=1){
                    switchFragment(lastfragment,1);
                    lastfragment = 1;
                }
                break;
            }
            case R.id.button3:{
                if(lastfragment!=2){
                    switchFragment(lastfragment,2);
                    lastfragment = 2;
                }
                break;
            }
            case R.id.button4:{
                if(lastfragment!=3){
                    switchFragment(lastfragment,3);
                    lastfragment = 3;
                }
                break;
            }
        }

    }

    private void initfragment(){
        fragment1 = new FragmentQ1();
        fragment2 = new FragmentQ2();
        fragment3 = new FragmentQ3();
        fragment4 = new FragmentQ4();
        fragments = new Fragment[]{fragment1,fragment2,fragment3,fragment4};
    }
    private void switchFragment(int lastfragment, int index){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);
        if(!fragments[index].isAdded()){
            transaction.add(R.id.fragment_question,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
}
