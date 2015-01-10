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
import android.widget.TextView;

import com.example.administrator.tuikudemo.Model.Topic;
import com.example.administrator.tuikudemo.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class TopicItemViewAdapter extends RecyclerView.Adapter<TopicItemViewAdapter.ViewHolder> {

    Context context;

    List<Topic> topicList;

    public TopicItemViewAdapter(Context context,List<Topic> topicList) {

        this.context = context;
        topicList.add(new Topic("", Color.WHITE, R.drawable.site_plus));
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

        public CardView cardView;

        public TextView textView;

        public CircleImageView circleImageView;

        public ViewHolder(View v) {
            super(v);

            cardView = (CardView) v.findViewById(R.id.cardView);
            textView = (TextView) cardView.findViewById(R.id.textView);
            circleImageView = (CircleImageView) cardView.findViewById(R.id.circleImageView);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    // We need to post a Runnable to show the popup to make sure that the PopupMenu is
                    // correctly positioned. The reason being that the view may change position before the
                    // PopupMenu is shown.
                    v.post(new Runnable() {
                        @Override
                        public void run() {

                            PopupMenu popupMenu = new PopupMenu(context, v);
                            popupMenu.inflate(R.menu.popup);
                            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    switch (menuItem.getItemId()) {
                                        case R.id.menu_remove:
                                            int position = getPosition();
                                            TopicItemViewAdapter.this.notifyItemRemoved(position);
                                            topicList.remove(position);
                                            return true;
                                    }
                                    return false;
                                }
                            });
                            popupMenu.show();
                        }
                    });
                }
            });
        }
    }

}
