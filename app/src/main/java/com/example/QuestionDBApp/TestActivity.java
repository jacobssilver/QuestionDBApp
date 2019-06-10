package com.example.QuestionDBApp;

import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    //fragment
    private FragmentQ1 fragment1;
    private FragmentQ2 fragment2;
    private FragmentQ3 fragment3;
    private FragmentQ4 fragment4;
    private Fragment[] fragments;
    private  int lastfragment=0;
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
        initfragment();
        int i=0;
        switch (questionList.get(i).getType()){
            case 1:{
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment1).show(fragment1).commit();
                break;
            }
            case 2:{
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment2).show(fragment2).commit();
                break;
            }
            case 3:{
                System.out.println("成功进入3");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_question , fragment3).show(fragment3).commit();
                break;
            }
            case 4:{
                break;
            }

        }
    }

    public void onitemclick(View v){
        switch (v.getId()){
            case R.id.question_list:{
                Toast.makeText(TestActivity.this,"you have clicked Button3",Toast.LENGTH_SHORT).show();
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

    public void initQuestionList(){
        Question question1 = new Question(1,R.drawable.img_a,R.drawable.answer);
        Question question2 = new Question(2,R.drawable.img_b,R.drawable.answer);
        Question question3 = new Question(3,R.drawable.img_c,R.drawable.answer);

        questionList.add(question3);
        questionList.add(question1);
        questionList.add(question3);
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
        transaction.hide(fragments[lastfragment]);
        if(!fragments[index].isAdded()){
            transaction.add(R.id.fragment_question,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
}
