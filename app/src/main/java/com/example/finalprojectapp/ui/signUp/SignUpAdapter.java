package com.example.finalprojectapp.ui.signUp;

import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.common.interfaces.StatusAction;

public interface SignUpAdapter {
    interface View extends StatusAction.ActionLoadingAndSuccess {
        void cancelSignUp();
        void failedMessage();
    }
    interface Model {
        void onSignUp(User user);
    }
    interface Presenter {
        void onSignUpAction(User user, User userVerify );
        void onSignUpCancel();
        void onSignUpComplete();
        void onSignUpFailed();
    }
}
