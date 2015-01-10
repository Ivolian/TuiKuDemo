package com.example.administrator.tuikudemo.Adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tuikudemo.Model.Topic;
import com.example.administrator.tuikudemo.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class TopicItemViewAdapter extends RecyclerView.Adapter<TopicItemViewAdapter.ViewHolder> {

    List<Topic> topicList;

    public TopicItemViewAdapter(List<Topic> topicList) {

        this.topicList = topicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.topic_item_view, viewGroup, false);

        return new ViewHolder(v);
    }

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

    public class ViewHolder extends RecyclerView.ViewHolder {

        // views in itemView
        public final CardView cardView;

        public final TextView textView;

        public CircleImageView circleImageView;

        public ViewHolder(View v) {
            super(v);

            // 1 持有引用
            cardView = (CardView) v.findViewById(R.id.cardView);
            textView = (TextView) cardView.findViewById(R.id.textView);
            circleImageView = (CircleImageView) cardView.findViewById(R.id.circleImageView);

            // 2 添加事件
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    cardView.setCardElevation(cardView.getCardElevation() + 10);
                }
            });
        }
    }

}
