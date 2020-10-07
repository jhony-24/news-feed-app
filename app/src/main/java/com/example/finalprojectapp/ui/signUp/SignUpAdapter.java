package com.example.finalprojectapp.ui.signUp;

import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.ui.login.LoginAdapter;
import com.example.finalprojectapp.utils.commonInterfaces.StatusAction;

public interface SignUpAdapter {
    interface View extends StatusAction.ActionLoadingAndSuccess {
        void cancelSignUp();
    }
    interface Model {
        void onSignUp(User user);
    }
    interface Presenter {
        void onSignUpAction(User user);
        void onSignUpCancel();
        void onSignUpComplete();
        void onSignUpFailed();
    }
}
