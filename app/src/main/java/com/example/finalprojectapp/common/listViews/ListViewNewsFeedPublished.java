package com.example.finalprojectapp.common.listViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.entities.NewsFeedPublished;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class ListViewNewsFeedPublished extends BaseAdapter {
    private Context context;
    private ArrayList<NewPost> listItemsNewsFeed;

    public ListViewNewsFeedPublished(Context context, ArrayList<NewPost> listItemsNewsFeed) {
        this.context = context;
        this.listItemsNewsFeed = listItemsNewsFeed;
    }
    @Override
    public int getCount() {
        return this.listItemsNewsFeed.size();
    }

    @Override
    public NewPost getItem(int i) {
        return listItemsNewsFeed.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NewPost news = getItem(i);
        view = LayoutInflater.from(this.context).inflate(R.layout.widget_new_feed_published,null);
        TextView fullName = (TextView)view.findViewById(R.id.cardNewsFeedTextFullName);
        CircleImageView avatar = (CircleImageView)view.findViewById(R.id.cardNewsFeedAvatar);
        TextView datetime = (TextView)view.findViewById(R.id.cardNewsFeedTextDateTime);
        TextView message = (TextView)view.findViewById(R.id.cardNewsFeedTextMessage);
        ImageView image = (ImageView)view.findViewById(R.id.cardNewsFeedImage);

        fullName.setText(news.getFullName());
        datetime.setText(news.getDatetime());
        message.setText(news.getMessage());
        return view;
    }
}
