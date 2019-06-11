package com.example.QuestionDBApp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        getSupportActionBar().hide();

        Button logout = findViewById(R.id.logout);

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
    }
}
