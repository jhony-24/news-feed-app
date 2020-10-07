package com.example.finalprojectapp.ui.login;

import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.utils.commonInterfaces.StatusAction;

public interface LoginAdapter {
    interface View extends StatusAction.ActionLoadingAndSuccess {
        void emptyFields();
        void navigateToMainApplication();
    }
    interface Model{
        void onSignIn(User user);
    }
    interface Presenter {
        void onSignIn(final String email,final String password);
        void onSignComplete();
        void onSignFailed();
    }
}
