package com.example.administrator.tuikudemo.Fragment;

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
import com.example.administrator.tuikudemo.Helper.TopicFragmentHelper;
import com.example.administrator.tuikudemo.Model.Topic;
import com.example.administrator.tuikudemo.R;

import java.util.ArrayList;
import java.util.List;


public class TopicFragment extends Fragment {

    // ======================== fields ========================

    RecyclerView recyclerView;

    int gridColumn = 3;

    // ======================== onCreateView ========================

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_topic, container, false);
        recyclerView.setLayoutManager(getGridLayoutManager());
        recyclerView.setVerticalScrollBarEnabled(false); // 隐藏滚动条
        recyclerView.setAdapter(new TopicItemViewAdapter(getActivity(), getRandomTopicList()));

        return recyclerView;
    }

    // ======================== menu ========================

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

    // ======================== other functions ========================

    private List<Topic> getRandomTopicList() {

        List<Topic> topicList = new ArrayList<>();
        for (int i = 0; i != 4; i++) {
            topicList.add(TopicFragmentHelper.getRandomTopic());
        }

        return topicList;
    }

    private void changeRecyclerViewLayout() {

        int position = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        gridColumn = (gridColumn == 3 ? 2 : 3);
        recyclerView.setLayoutManager(getGridLayoutManager());
        recyclerView.scrollToPosition(position);
    }

    private GridLayoutManager getGridLayoutManager() {

        return new GridLayoutManager(getActivity(), gridColumn);
    }

}
