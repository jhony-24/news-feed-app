package com.example.finalprojectapp.ui.signUp;

import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.repositories.SignUpRepository;

public class SignUpPresenter implements  SignUpAdapter.Presenter {

    SignUpAdapter.View signUpView;
    SignUpAdapter.Model signUpModel;

    public SignUpPresenter(SignUpAdapter.View signUpView){
        this.signUpView = signUpView;
        this.signUpModel = new SignUpModel(this,new SignUpRepository());
    }

    @Override
    public void onSignUpAction(User user) {
        this.signUpModel.onSignUp(user);
    }

    @Override
    public void onSignUpCancel() {
        this.signUpView.cancelSignUp();
    }

    @Override
    public void onSignUpComplete() {
        this.signUpView.success();
    }

    @Override
    public void onSignUpFailed() {
        this.signUpView.success();
    }
}
