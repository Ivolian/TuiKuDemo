package com.example.administrator.tuikudemo.Activity;

import android.os.Bundle;

import com.example.administrator.tuikudemo.Activity.Base.GeneralActivity;
import com.example.administrator.tuikudemo.R;


public class FeedbackActivity extends GeneralActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initToolbar("意见反馈");
    }

}
