package com.example.finalprojectapp.data.interfaces;
import com.example.finalprojectapp.data.entities.NewPost;
import java.util.ArrayList;

public interface LoadNewsFeedPort {
    interface LoadNewsFeed {
        void load(ArrayList<NewPost> listNewsPost);
    }
    void loadNewsFeed(LoadNewsFeed loadNewsFeed);
}
