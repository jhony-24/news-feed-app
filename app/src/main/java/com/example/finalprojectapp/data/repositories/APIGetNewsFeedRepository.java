package com.example.finalprojectapp.data.repositories;
import com.example.finalprojectapp.data.entities.NewsFeedPublished;
import com.example.finalprojectapp.data.services.NewsFeedService;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIGetNewsFeedRepository {

    public interface LoadDataCallback {
        void load(ArrayList<NewsFeedPublished> newsFeedPublished);
        void failed();
    }

    public static void load(LoadDataCallback loadDataCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://green-king-27f9.devcoder.workers.dev")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsFeedService newsFeedService = retrofit.create(NewsFeedService.class);
        Call<ArrayList<NewsFeedPublished>> newsFeedServiceAsync = newsFeedService.getNewsFeed();

        newsFeedServiceAsync.enqueue(new Callback<ArrayList<NewsFeedPublished>>() {
            @Override
            public void onResponse(Call<ArrayList<NewsFeedPublished>> call, Response<ArrayList<NewsFeedPublished>> response) {
                if(response.isSuccessful()) {
                    ArrayList<NewsFeedPublished> data = response.body();
                    loadDataCallback.load(data);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<NewsFeedPublished>> call, Throwable t) {
                loadDataCallback.failed();
            }
        });
    }
}
