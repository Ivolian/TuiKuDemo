package com.example.administrator.tuikudemo.Helper;

import android.content.res.Resources;

import com.example.administrator.tuikudemo.Model.Topic;
import com.example.administrator.tuikudemo.R;

import java.util.Random;


public class TopicFragmentHelper {

    static int[] resIds = new int[]{
            R.drawable.i1,
            R.drawable.i2,
            R.drawable.i3,
            R.drawable.i4,
            R.drawable.i5,
            R.drawable.i6,
            R.drawable.i7,
            R.drawable.i8,
            R.drawable.i9
    };

    static Resources resources = Resources.getSystem();
    static int[] colors = new int[]{
            resources.getColor(android.R.color.holo_blue_bright),
            resources.getColor(android.R.color.holo_blue_dark),
            resources.getColor(android.R.color.holo_blue_light),
            resources.getColor(android.R.color.holo_green_dark),
            resources.getColor(android.R.color.holo_green_light),
            resources.getColor(android.R.color.holo_orange_dark),
            resources.getColor(android.R.color.holo_orange_light),
            resources.getColor(android.R.color.holo_purple),
            resources.getColor(android.R.color.holo_red_dark),
            resources.getColor(android.R.color.holo_red_light)
    };

    public static int getRandomResId() {

        return resIds[new Random().nextInt(resIds.length)];
    }

    public static int getRandomColor() {

        return colors[new Random().nextInt(colors.length)];
    }

    public static Topic getRandomTopic() {

        return new Topic(getRandomColor(), getRandomResId());
    }

}
