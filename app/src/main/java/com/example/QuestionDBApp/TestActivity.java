package com.example.QuestionDBApp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.QuestionDBApp.fragment.FragmentQ1;
import com.example.QuestionDBApp.fragment.FragmentQ2;
import com.example.QuestionDBApp.fragment.FragmentQ3;
import com.example.QuestionDBApp.fragment.FragmentQ4;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private List<Question> questionList = new ArrayList<>();
    int i=0;

    //fragment
    private FragmentQ1 fragment1;
    private FragmentQ2 fragment2;
    private FragmentQ3 fragment3;
    private FragmentQ4 fragment4;
    private Fragment[] fragments;
    private  int lastfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);
        getSupportActionBar().hide();

        //back
        ImageView back = findViewById(R.id.back_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initQuestionList();

        int type = questionList.get(i).getType();
        initfragment();
        lastfragment=type-1;

        switch(type){
            case 1:{
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment1).show(fragment1).commit();
                Bundle bundle = new Bundle();
                bundle.putInt("QuestionImg",questionList.get(i).getImg());//题目传入fragment
                fragment1.setArguments(bundle);
                break;
            }
            case 2:{
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment2).show(fragment2).commit();
                Bundle bundle = new Bundle();
                bundle.putInt("QuestionImg",questionList.get(i).getImg());//题目传入fragment
                fragment2.setArguments(bundle);
                break;
            }
            case 3:{
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment3).show(fragment3).commit();
                Bundle bundle = new Bundle();
                bundle.putInt("QuestionImg",questionList.get(i).getImg());//题目传入fragment
                fragment3.setArguments(bundle);
                break;
            }
            case 4:{
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment4).show(fragment4).commit();
                Bundle bundle = new Bundle();
                bundle.putInt("QuestionImg",questionList.get(i).getImg());//题目传入fragment
                fragment4.setArguments(bundle);
                break;
            }
        }


        ImageView go_question = findViewById(R.id.go_question);
        ImageView back_quesion = findViewById(R.id.back_question);
        go_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<questionList.size()-1){
                    System.out.println("enter go");
                    i++;
                    int img = questionList.get(i).getImg();
                    int type = questionList.get(i).getType();
                    Bundle bundle = new Bundle();
                    bundle.putInt("QuestionImg",img);
                    if(lastfragment!=type-1){
                        System.out.println("enterswitch");
                        switchFragment(lastfragment,type-1);
                        fragments[type].setArguments(bundle);
                        lastfragment=type-1;
                    }
                    else{
                        System.out.println("enter no_change");

                        getSupportFragmentManager().beginTransaction().show(fragments[lastfragment]).commit();
                        fragments[lastfragment].setArguments(bundle);
                    }
                }
                else{
                    Toast toast = Toast.makeText(TestActivity.this,"已是最后一题",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
        back_quesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("enter back");
                if(i>0){
                    i--;
                    System.out.println("enter recycle");
                    int img = questionList.get(i).getImg();
                    int type = questionList.get(i).getType();
                    Bundle bundle = new Bundle();
                    bundle.putInt("QuestionImg",img);
                    if(lastfragment!=type-1){
                        System.out.println("enter switch");
                        switchFragment(lastfragment,type-1);
                        fragments[type].setArguments(bundle);
                        lastfragment=type-1;

                    }
                    else{
                        System.out.println("enter back");
                        getSupportFragmentManager().beginTransaction().show(fragments[lastfragment]).commit();
                        fragments[lastfragment].setArguments(bundle);
                        System.out.println("enter no_change");
                    }
                }
                else{
                    Toast toast = Toast.makeText(TestActivity.this,"已是第一题",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });


    }


    public void initQuestionList(){
        Question question1 = new Question(1,R.drawable.img_a,R.drawable.answer);
        Question question2 = new Question(2,R.drawable.img_b,R.drawable.answer);
        Question question3 = new Question(3,R.drawable.img_c,R.drawable.answer);

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question2);
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
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

        if(!fragments[index].isAdded()){
            transaction.hide(fragments[lastfragment]).add(R.id.fragment_question,fragments[index]).commit();
        }
        else{
            transaction.hide(fragments[lastfragment]).show(fragments[index]).commit();
        }

    }
}
