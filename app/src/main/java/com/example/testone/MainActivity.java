package com.example.testone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import fireworks.FireworksActivity;
import gaodeMapSdk.MapGaoDeActivity;
import tencentMapSDK.TencentMapActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
    }

    public void findViewById() {
        //高德地图
        findViewById(R.id.mapGaoDe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapGaoDeActivity.class));
            }
        });

        findViewById(R.id.mapTencent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TencentMapActivity.class));
            }
        });

        findViewById(R.id.fireworks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FireworksActivity.class));
            }
        });
    }
}