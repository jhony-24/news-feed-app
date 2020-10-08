package com.example.finalprojectapp.ui.news;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.repositories.GetNewsFeedRepository;
import com.example.finalprojectapp.data.repositories.PublishNewsRepository;

import java.util.ArrayList;

public class NewsPresenter implements NewsAdapter.Presenter{

    private NewsAdapter.Model newsModel;
    private NewsAdapter.View newsView;

    public  NewsPresenter(NewsAdapter.View newsView ) {
        this.newsView = newsView;
        this.newsModel = new NewsModel(this,new PublishNewsRepository(), new GetNewsFeedRepository());
    }

    @Override
    public void onPostANews() {
        this.newsModel.onPostANews(new NewPost());
    }

    @Override
    public void onPublishNewsComplete() {
        this.newsView.success();
    }

    @Override
    public void onPublishNewsFailed() {
        this.newsView.loading();
    }

    @Override
    public void onLoadNewsFeed(ArrayList<NewPost> listNewPost) {
        this.newsView.onLoadNewsFeed(listNewPost);
    }
}
