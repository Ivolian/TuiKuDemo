package com.example.administrator.tuikudemo.Helper;

import com.example.administrator.tuikudemo.Model.Topic;
import com.example.administrator.tuikudemo.R;
import com.example.administrator.tuikudemo.Util.ColorUtil;

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

    static int[] colors = new int[]{
            ColorUtil.getColor(android.R.color.holo_blue_bright),
            ColorUtil.getColor(android.R.color.holo_blue_dark),
            ColorUtil.getColor(android.R.color.holo_blue_light),
            ColorUtil.getColor(android.R.color.holo_green_dark),
            ColorUtil.getColor(android.R.color.holo_green_light),
            ColorUtil.getColor(android.R.color.holo_orange_dark),
            ColorUtil.getColor(android.R.color.holo_orange_light),
            ColorUtil.getColor(android.R.color.holo_purple),
            ColorUtil.getColor(android.R.color.holo_red_dark),
            ColorUtil.getColor(android.R.color.holo_red_light)
    };

    public static Topic getRandomTopic() {

        return new Topic(getRandomColor(), getRandomResId());
    }

    private static int getRandomResId() {

        return resIds[new Random().nextInt(resIds.length)];
    }

    private static int getRandomColor() {

        return colors[new Random().nextInt(colors.length)];
    }

}
