package com.example.finalprojectapp.ui.profile;

import com.example.finalprojectapp.common.interfaces.StatusAction;
import com.example.finalprojectapp.data.entities.User;

public interface ProfileAdapter {
    interface View extends StatusAction.ActionLoadingAndSuccess {
        void showUserProfile(User user);
    }
    interface Model{
        void onLoadUserProfile(User user);
    }
    interface Presenter{
        void onLoadUserProfile(String id);
        void onLoadUserProfileComplete(User user);
    }
}