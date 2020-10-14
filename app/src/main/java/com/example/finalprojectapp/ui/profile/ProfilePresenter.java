package com.example.finalprojectapp.ui.profile;

import com.example.finalprojectapp.data.entities.User;

public class ProfilePresenter implements  ProfileAdapter.Presenter{
    ProfileAdapter.View view;
    ProfileAdapter.Model model;

    public ProfilePresenter(ProfileAdapter.View view) {
        this.view = view;
        this.model = new ProfileModel(this);
    }

    @Override
    public void onLoadUserProfile(String id) {
        User user = new User();
        user.setId(id);
        this.view.loading();
        this.model.onLoadUserProfile(user);
        this.view.success();
    }

    @Override
    public void onLoadUserProfileComplete(User user) {
        this.view.showUserProfile(user);
    }
}
