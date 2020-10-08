package com.example.finalprojectapp.ui.news;

import com.example.finalprojectapp.common.interfaces.StatusAction;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.interfaces.LoadNewsFeedPort;
import com.example.finalprojectapp.data.interfaces.PublishNewsPort;

public class NewsModel implements NewsAdapter.Model{
    private NewsAdapter.Presenter publishNewsPresenter;
    private PublishNewsPort publishNewsPort;
    private LoadNewsFeedPort loadNewsFeedPort;

    public  NewsModel(
            NewsAdapter.Presenter publishNewsPresenter,
            PublishNewsPort publishNewsPort,
            LoadNewsFeedPort loadNewsFeedPort) {
        this.publishNewsPort = publishNewsPort;
        this.publishNewsPresenter = publishNewsPresenter;
        this.loadNewsFeedPort = loadNewsFeedPort;
    }

    @Override
    public void onPostANews(NewPost newPost) {
        this.publishNewsPort.addNewPost(newPost, new StatusAction.ActionSuccessAndFailed() {
            @Override
            public void success() {
                NewsModel.this.publishNewsPresenter.onPublishNewsComplete();;
            }

            @Override
            public void failed() {
                NewsModel.this.publishNewsPresenter.onPublishNewsFailed();
            }
        });
    }

    @Override
    public void onLoadNewsFeed() {
        this.loadNewsFeedPort.loadNewsFeed(news -> {
            this.publishNewsPresenter.onLoadNewsFeed(news);
        });
    }
}
