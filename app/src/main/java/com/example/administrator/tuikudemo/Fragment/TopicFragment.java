package com.example.administrator.tuikudemo.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.tuikudemo.Adapter.TopicItemViewAdapter;
import com.example.administrator.tuikudemo.Model.Topic;
import com.example.administrator.tuikudemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TopicFragment extends Fragment {

    int[] resIds = new int[]{
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

    Resources resources = Resources.getSystem();
    int[] colors = new int[]{
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

    RecyclerView recyclerView;

    int column = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_topic, container, false);
        recyclerView.setLayoutManager(getGridLayoutManager());
        // 隐藏滚动条
        recyclerView.setVerticalScrollBarEnabled(false);
        TopicItemViewAdapter topicItemViewAdapter = new TopicItemViewAdapter(getActivity(), getTopicList());
        recyclerView.setAdapter(topicItemViewAdapter);

        return recyclerView;
    }

    private GridLayoutManager getGridLayoutManager() {

        return new GridLayoutManager(getActivity(), column);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.topic_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.change_layout:
                changeRecyclerViewLayout();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Topic> getTopicList() {

        List<Topic> topicList = new ArrayList<>();
        for (int i = 0; i != 20; i++) {
            topicList.add(new Topic(i + 1 + "", getRandomColor(), getRandomResId()));
        }

        return topicList;
    }

    private int getRandomResId() {

        return resIds[new Random().nextInt(resIds.length)];
    }

    public int getRandomColor() {

        return colors[new Random().nextInt(colors.length)];
    }

    private void changeRecyclerViewLayout() {

        int position = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        column = (column == 3 ? 2 : 3);
        recyclerView.setLayoutManager(getGridLayoutManager());
        recyclerView.scrollToPosition(position);
    }

}
