package com.example.administrator.tuikudemo.Util;


import android.content.res.Resources;

public class ColorUtil {

    public static int getColor(int id) {

        Resources resources = Resources.getSystem();
        return resources.getColor(id);
    }

}
