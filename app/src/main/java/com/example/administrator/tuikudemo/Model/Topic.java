package com.example.administrator.tuikudemo.Model;

public class Topic {

    private int color;

    private int resId;

    public Topic(int color, int resId) {
        this.color = color;
        this.resId = resId;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

}
