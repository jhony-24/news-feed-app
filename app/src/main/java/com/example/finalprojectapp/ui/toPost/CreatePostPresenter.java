package com.example.finalprojectapp.ui.toPost;

public class CreatePostPresenter implements  CreatePostAdapter.Presenter {

    CreatePostAdapter.View view;

    public CreatePostPresenter(CreatePostAdapter.View view){
        this.view = view;
    }
}
