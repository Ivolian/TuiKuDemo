package com.example.administrator.tuikudemo.Model;

public class Topic {

    private String text;

    private int color;

    private int resId;

    public Topic(String text, int color, int resId) {
        this.text = text;
        this.color = color;
        this.resId = resId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
