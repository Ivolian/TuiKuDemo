package com.example.administrator.tuikudemo.Activity;

import android.os.Bundle;

import com.example.administrator.tuikudemo.R;


public class AboutActivity extends GeneralActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initToolbar("关于我们");
    }

}
