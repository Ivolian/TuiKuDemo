package com.example.administrator.tuikudemo.Util;

import android.app.Activity;
import android.content.Intent;

import com.example.administrator.tuikudemo.R;


public class ActivityUtil {

    public static void startActivityWithAnim(Activity fromActivity, Class toActivityClass) {

        Intent intent = new Intent(fromActivity, toActivityClass);
        fromActivity.startActivity(intent);
        fromActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void finishActivityWithAnim(Activity finishActivity) {
        finishActivity.finish();
        finishActivity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
