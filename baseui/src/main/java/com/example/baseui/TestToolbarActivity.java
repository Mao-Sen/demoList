package com.example.baseui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import per.goweii.actionbarex.common.ActionBarCommon;

public class TestToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        ActionBarCommon actionBarCommon = findViewById(R.id.abc);
        actionBarCommon.getForegroundLayer().setVisibility(View.VISIBLE);
    }
}