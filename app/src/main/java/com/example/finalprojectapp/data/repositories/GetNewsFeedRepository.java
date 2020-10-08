package com.example.finalprojectapp.data.repositories;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.interfaces.LoadNewsFeedPort;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.ArrayList;

public class GetNewsFeedRepository implements LoadNewsFeedPort {
    FirebaseFirestore db;
    public GetNewsFeedRepository() {
        this.db = FirebaseFirestore.getInstance();
    }
    @Override
    public void loadNewsFeed(LoadNewsFeed loadNewsFeed) {
        this.db.collection("news").addSnapshotListener((value,error) -> {
            if(error != null) return;
            ArrayList<NewPost> news = new ArrayList<NewPost>();
            for(QueryDocumentSnapshot document: value) {
                news.add(
                        new NewPost(
                        document.getString("avatar"),
                        document.getString("fullName"),
                        document.getString("datetime"),
                        document.getString("message"))
                );
            }
            loadNewsFeed.load(news);
        });
    }
}
