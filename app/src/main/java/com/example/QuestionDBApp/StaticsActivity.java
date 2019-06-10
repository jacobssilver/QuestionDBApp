package com.example.QuestionDBApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StaticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statics);
        getSupportActionBar().hide();
    }
}
