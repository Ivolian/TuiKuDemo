package com.example.administrator.tuikudemo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tuikudemo.R;

public class OfflineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_offline, container, false);

        TextView textView = (TextView)rootView.findViewById(R.id.textView);
        String html= "<html><body><div><h2> 英雄联盟 — 你所不知道的冷知识 </h2></div><div>1. 其实盲僧的回旋踢可以对队友使用，所以喷谁也不能喷盲僧啊。</div><div>2. 狐狸的大最高可以4段，如果你把闪现也算进去。</div><div>3. 卢锡安是全英雄联盟中连击数最高的英雄，因为他的大招是biubiubiu。</div><div>4. 狗头是英雄联盟中潜力最大的英雄，你看过他一Q秒大龙的视频吗？</div></body></html>";
        textView.setText(Html.fromHtml(html));

        return rootView;
    }

}
