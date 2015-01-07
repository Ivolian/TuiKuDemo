package com.example.administrator.tuikudemo.Util;

import android.app.Activity;
import android.content.Intent;

import com.example.administrator.tuikudemo.R;


public class ActivityUtil {

    public static void startActivityWithAnim(Activity from, Class to) {

        Intent intent = new Intent(from, to);
        from.startActivity(intent);
        from.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void finishActivityWithAnim(Activity toFinish) {
        toFinish.finish();
        toFinish.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
