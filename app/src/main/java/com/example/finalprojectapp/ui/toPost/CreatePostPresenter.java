package com.example.finalprojectapp.ui.toPost;

import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.entities.User;

public class CreatePostPresenter implements  CreatePostAdapter.Presenter {

    CreatePostAdapter.View view;
    CreatePostAdapter.Model model;

    public CreatePostPresenter(CreatePostAdapter.View view){
        this.view = view;
        this.model = new CreatePostModel(this);
    }

    @Override
    public void createNewPost( NewPost newPost) {
        this.model.createNewPost(newPost);
    }

    @Override
    public void success() {

    }

    @Override
    public void failed() {

    }
}
