package com.example.administrator.tuikudemo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.tuikudemo.Helper.TopicFragmentHelper;
import com.example.administrator.tuikudemo.Model.Topic;
import com.example.administrator.tuikudemo.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class TopicItemViewAdapter extends RecyclerView.Adapter<TopicItemViewAdapter.ViewHolder> {

    // ======================== fields ========================

    Context context;

    List<Topic> topicList;

    // ======================== constructor ========================

    public TopicItemViewAdapter(Context context, List<Topic> topicList) {

        this.context = context;
        this.topicList = topicList;
        // 添加末尾项
        this.topicList.add(new Topic(Color.WHITE, R.drawable.site_plus));
    }

    // ======================== onCreateViewHolder ========================

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.topic_item_view, viewGroup, false);

        return new ViewHolder(v);
    }

    // ======================== onBindViewHolder ========================

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Topic topic = topicList.get(position);
        viewHolder.cardView.setCardBackgroundColor(topic.getColor());
        viewHolder.circleImageView.setImageResource(topic.getResId());
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    // ======================== ViewHolder ========================

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        public CardView cardView;

        public CircleImageView circleImageView;

        public ViewHolder(View v) {
            super(v);

            cardView = (CardView) v.findViewById(R.id.cardView);
            circleImageView = (CircleImageView) cardView.findViewById(R.id.circleImageView);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getPosition();
            if (position + 1 == topicList.size()) {
                topicList.add(position, TopicFragmentHelper.getRandomTopic());
                TopicItemViewAdapter.this.notifyItemInserted(position);
            } else {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.inflate(R.menu.popup);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.show();
            }
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            int position = getPosition();
            TopicItemViewAdapter.this.notifyItemRemoved(position);
            topicList.remove(position);
            return true;
        }

    }

}
