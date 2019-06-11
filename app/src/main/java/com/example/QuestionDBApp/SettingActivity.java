package com.example.QuestionDBApp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        getSupportActionBar().hide();

        Button logout = findViewById(R.id.logout);
        ImageView back = findViewById(R.id.back_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences share = getSharedPreferences("Login",
                        Context.MODE_PRIVATE);
                share.edit().putBoolean("LoginBool", false).apply();
                Intent intent = new Intent(SettingActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        // 创建SharedPreferences对象用于储存帐号和密码,并将其私有化
        SharedPreferences share = getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        TextView username = findViewById(R.id.username);
        username.setText(share.getString("Account", ""));
        ConstraintLayout name = findViewById(R.id.setting_name);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SettingActivity.this);
                final AlertDialog dialog =builder.create();
                View dialogView = View.inflate(SettingActivity.this,R.layout.memo_edit,null);
                builder.setTitle("修改便签");


                final EditText edit = dialogView.findViewById(R.id.memoEditText);
                Button confirm =dialogView.findViewById(R.id.confirm);
                Button cancel = dialogView.findViewById(R.id.cancel);
                edit.setHint("输入新的用户名");

                dialog.setView(dialogView);
                dialog.show();

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 创建SharedPreferences对象用于储存帐号和密码,并将其私有化
                        SharedPreferences share = getSharedPreferences("Login",
                                Context.MODE_PRIVATE);
                        // 获取编辑器来存储数据到sharedpreferences中
                        Editor editor = share.edit();
                        editor.putString("Account", edit.getText().toString());
                        editor.commit();
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
}
