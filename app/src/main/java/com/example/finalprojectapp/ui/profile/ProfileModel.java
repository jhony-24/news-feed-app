package com.example.finalprojectapp.ui.profile;

import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.interfaces.LoadUserPort;
import com.example.finalprojectapp.data.repositories.GetProfileDataRepository;

public class ProfileModel implements  ProfileAdapter.Model{

    ProfileAdapter.Presenter presenter;
    LoadUserPort loadUserPort = new GetProfileDataRepository();
    public ProfileModel(ProfileAdapter.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onLoadUserProfile(User user) {
        this.loadUserPort.getUserDataById(user, ( userGetComplete ) -> {
           this.presenter.onLoadUserProfileComplete(userGetComplete);
        });
    }
}