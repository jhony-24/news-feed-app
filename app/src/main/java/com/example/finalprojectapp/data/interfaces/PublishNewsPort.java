package com.example.finalprojectapp.data.interfaces;
import com.example.finalprojectapp.common.interfaces.StatusAction;
import com.example.finalprojectapp.data.entities.NewPost;

public interface PublishNewsPort {
    void addNewPost(NewPost newPost, StatusAction.ActionSuccessAndFailed statusAction);
}
