package com.example.administrator.tuikudemo.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.administrator.tuikudemo.R;

public class ArticleFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_article, container, false);

        initImageView(R.id.iv_jian, 130, "荐", "#69F0AE");
        initImageView(R.id.iv_ying, 60, "营销", "#FF8A80");
        initImageView(R.id.iv_bian, 70, "编程", "#2196F3");
        initImageView(R.id.iv_shu, 45, "数码", "#8D6E63");
        initImageView(R.id.iv_ke, 70, "科技", "#E040FB");
        initImageView(R.id.iv_she, 45, "设计", "#536DFE");
        initImageView(R.id.iv_chan, 65, "产品", "#AEEA00");

        initImageView(R.id.iv_chang, 57, "创业", "#8BC34A");

        return rootView;
    }

    private void initImageView(int imageViewId, int fontSize, String text, String color) {

        if (rootView == null) {
            throw new RuntimeException("initImageView: rootView doesn't init");
        }

        ImageView imageView = (ImageView) rootView.findViewById(imageViewId);
        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .fontSize(fontSize)
                .endConfig()
                .buildRound(text, Color.parseColor(color));
        imageView.setImageDrawable(drawable);
    }



}
