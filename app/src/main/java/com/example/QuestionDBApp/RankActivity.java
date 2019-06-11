package com.example.QuestionDBApp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RankActivity extends AppCompatActivity {

    private List<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_list);
        getSupportActionBar().hide();
        initRank();
        RecyclerView rank_recycler = findViewById(R.id.rank_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rank_recycler.setLayoutManager(layoutManager);
        RankAdapter rankAdapter = new RankAdapter(this,userList);
        rank_recycler.setAdapter(rankAdapter);
        ImageView back = findViewById(R.id.back_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void initRank(){
        User user = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user1 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user2 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user3 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user4 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user5 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user6 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user7 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user8 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        User user9 = new User(R.drawable.head_icon,"用户名","个性签名","答题个数：999");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);

    }
}
