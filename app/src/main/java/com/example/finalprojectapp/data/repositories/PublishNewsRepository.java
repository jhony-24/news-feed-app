package com.example.finalprojectapp.data.repositories;
import com.example.finalprojectapp.common.interfaces.StatusAction;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.interfaces.PublishNewsPort;
import com.google.firebase.firestore.FirebaseFirestore;

public class PublishNewsRepository implements PublishNewsPort {
    FirebaseFirestore db;
    public PublishNewsRepository() {
        this.db = FirebaseFirestore.getInstance();
    }
    @Override
    public void addNewPost(NewPost newPost, StatusAction.ActionSuccessAndFailed statusAction) {
        this.db.collection("news").add(newPost)
                .addOnSuccessListener(task -> statusAction.success())
                .addOnFailureListener(task -> statusAction.failed());
    }
}
