package com.example.finalprojectapp.ui.toPost;
import com.example.finalprojectapp.common.interfaces.StatusAction;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.interfaces.PublishNewsPort;
import com.example.finalprojectapp.data.repositories.PublishNewsRepository;

public class CreatePostModel implements  CreatePostAdapter.Model {
    CreatePostAdapter.Presenter presenter;
    PublishNewsPort publishNewsPort;
    public  CreatePostModel(CreatePostAdapter.Presenter presenter){
        this.presenter = presenter;
        this.publishNewsPort = new PublishNewsRepository();
    }

    @Override
    public void createNewPost(NewPost newPost) {
        CreatePostModel self = this;
        this.publishNewsPort.addNewPost(newPost, new StatusAction.ActionSuccessAndFailed() {
            @Override
            public void success() {
                self.presenter.success();
            }
            @Override
            public void failed() {
                self.presenter.failed();
            }
        });
    }
}
