package com.example.QuestionDBApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private List<Comment> commentList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        getSupportActionBar().hide();

        initComment();
        RecyclerView recyclerView = findViewById(R.id.comment_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CommentAdapter commentAdapter = new CommentAdapter(this,commentList);
        recyclerView.setAdapter(commentAdapter);

    }

    public void initComment(){
        Comment comment = new Comment(R.drawable.head_icon,"回答用户一","回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容","999赞","2019.06.10");
        Comment comment1 = new Comment(R.drawable.head_icon,"回答用户一","回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容回答内容回内容","999赞","2019.06.10");
        commentList.add(comment);
        commentList.add(comment1);
        commentList.add(comment);
        commentList.add(comment1);
        commentList.add(comment);
        commentList.add(comment1);
        commentList.add(comment);
        commentList.add(comment1);
    }
}
