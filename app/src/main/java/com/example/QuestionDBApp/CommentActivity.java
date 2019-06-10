package com.example.QuestionDBApp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
        final CommentAdapter commentAdapter = new CommentAdapter(this, commentList);
        recyclerView.setAdapter(commentAdapter);

        final ImageView backbtn = findViewById(R.id.back_to_forum);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView writeanswer = findViewById(R.id.write_answer);
        writeanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CommentActivity.this);
                final AlertDialog dialog = builder.create();
                View dialogView = View.inflate(CommentActivity.this, R.layout.memo_edit, null);
                builder.setTitle("写回答");

                final EditText edit = dialogView.findViewById(R.id.memoEditText);
                Button confirm = dialogView.findViewById(R.id.confirm);
                Button cancel = dialogView.findViewById(R.id.cancel);
                edit.setHint("输入问题的回答");

                dialog.setView(dialogView);
                dialog.show();

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Answer = edit.getText().toString();
                        SharedPreferences share = getSharedPreferences("Login",
                                Context.MODE_PRIVATE);
                        String strAccount = share.getString("Account", "");

                        Comment comment = new Comment(R.drawable.head_icon,strAccount,Answer,"999赞","2019.06.10");
                        commentList.add(comment);
                        commentAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
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
