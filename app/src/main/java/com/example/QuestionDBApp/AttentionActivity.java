package com.example.QuestionDBApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AttentionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attention);
        getSupportActionBar().hide();
    }
}
