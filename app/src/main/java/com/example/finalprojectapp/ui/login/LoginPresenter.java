package com.example.finalprojectapp.ui.login;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.repositories.SignInRepository;

public class LoginPresenter implements  LoginAdapter.Presenter {
    LoginAdapter.View loginView;
    LoginAdapter.Model loginModel;
    public LoginPresenter(LoginAdapter.View loginView){
        this.loginView = loginView;
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
            user.email = email;
            user.password = password;
            this.loginModel.onSignIn(user);
        }
    }

    @Override
    public void onSignComplete() {
        this.loginView.success();
        this.loginView.navigateToMainApplication();
    }

    @Override
    public void onSignFailed() {
        this.loginView.success();
    }
}
