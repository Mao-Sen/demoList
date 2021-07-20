package com.example.testone;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import BackgroundColor.SampleActivity;
import Euclid.EuclidMainActivity;
import dialogSilde.DialogSlideActivity;
import myMP.HomeActivity;
import slidingDrawer.SlidingDrawerDemoActivity;
import staticproxy.ProxyActivity;
import titanictextview.TitanicTextViewActivity;

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

        findViewById(R.id.dialog_silde).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DialogSlideActivity.class));
            }
        });

        findViewById(R.id.sildingDrawer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SlidingDrawerDemoActivity.class));
            }
        });
        findViewById(R.id.picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });
    }
}