package com.example.finalprojectapp.ui.news;
import com.example.finalprojectapp.common.interfaces.StatusAction;
import com.example.finalprojectapp.data.entities.NewPost;

import java.util.ArrayList;

public interface NewsAdapter {
    interface View extends StatusAction.ActionLoadingAndSuccess {
        void onLoadNewsFeed(ArrayList<NewPost> listNewPost);
    }
    interface Model{
        void onPostANews(NewPost newPost);
        void onLoadNewsFeed();
    }
    interface Presenter{
        void onPostANews();
        void onPublishNewsComplete();
        void onPublishNewsFailed();
        void onLoadNewsFeed(ArrayList<NewPost> listNewPost);
    }
}
