package com.example.finalprojectapp.ui.toPost;

import com.example.finalprojectapp.common.interfaces.StatusAction;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.entities.User;

public interface CreatePostAdapter {
    interface View extends  StatusAction.ActionLoadingAndSuccess{
    }
    interface  Model {
        void createNewPost(NewPost newPost);
    }
    interface  Presenter extends StatusAction.ActionSuccessAndFailed {
        void createNewPost(NewPost newPost);
    }
}
