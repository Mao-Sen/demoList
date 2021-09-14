package com.example.baseui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class TestToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        //getWindow().setBackgroundDrawable(new ColorDrawable(ResUtils.getThemeColor(this, R.attr.colorBackground)));
    }
}