package com.example.finalprojectapp.data.services;
import com.example.finalprojectapp.data.entities.NewsFeedPublished;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsFeedService {
    @GET("/")
    Call<ArrayList<NewsFeedPublished>> getNewsFeed();
}
