package com.example.testone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import BackgroundColor.SampleActivity;
import Euclid.EuclidMainActivity;
import baiduMapSDK.BaiDuMapActivity;
import gaodeMapSdk.MapGaoDeActivity;
import staticproxy.ProxyActivity;
import tencentMapSDK.TencentMapActivity;
import titanictextview.TitanicTextViewActivity;
import viewFlipperActivity.ViewFlipperActivity;
import wechatActivityAnimation.wechatAnimationActivity;

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
        //代理模式
        findViewById(R.id.proxy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProxyActivity.class));
            }
        });
        //TitanicTextView
        findViewById(R.id.TitanicTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TitanicTextViewActivity.class));
            }
        });
        //ViewPager渐变背景色
        findViewById(R.id.sample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SampleActivity.class));
            }
        });

        findViewById(R.id.eucild).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EuclidMainActivity.class));
            }
        });

        findViewById(R.id.view_flipper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewFlipperActivity.class));
            }
        });

        findViewById(R.id.animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, wechatAnimationActivity.class));
            }
        });
        findViewById(R.id.mapBaidu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BaiDuMapActivity.class));
            }
        });
        findViewById(R.id.mapTencent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TencentMapActivity.class));
            }
        });
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button test = findViewById(R.id.test);
                test.setText("1234");
            }
        });
    }
}