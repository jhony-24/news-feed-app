package com.example.finalprojectapp.ui.login;
import android.app.Activity;
import android.content.Context;

import com.example.finalprojectapp.data.entities.PersistKeyValue;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.repositories.PersistUserAccountRepository;
import com.example.finalprojectapp.data.repositories.SignInRepository;

public class LoginPresenter implements  LoginAdapter.Presenter {
    LoginAdapter.View loginView;
    LoginAdapter.Model loginModel;
    private Activity activity;

    public LoginPresenter(LoginAdapter.View loginView, Activity activity){
        this.loginView = loginView;
        this.activity = activity;
        this.loginModel = new LoginModel(this,new SignInRepository());
    }

    @Override
    public void onSignIn(final String email,final String password) {
        if(email.isEmpty() || password.isEmpty()) {
            this.loginView.emptyFields();
        }
        else {
            this.loginView.loading();
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            this.loginModel.onSignIn(user);
        }
    }

    @Override
    public void onSignComplete(User user) {
        PersistKeyValue[] persistKeyValues = new PersistKeyValue[]{
                new PersistKeyValue("id",user.getId()),
                new PersistKeyValue("email",user.getEmail())
        };
        PersistUserAccountRepository repository = new PersistUserAccountRepository(this.activity);
        repository.persist(persistKeyValues);
        this.loginView.success();
        this.loginView.navigateToMainApplication();
    }

    @Override
    public void onSignFailed() {
        this.loginView.success();
    }
}
