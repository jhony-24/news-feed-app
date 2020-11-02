package com.example.finalprojectapp.ui.toPost;
import com.example.finalprojectapp.data.entities.NewPost;

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
        this.view.success();
    }

    @Override
    public void failed() {

    }
}
