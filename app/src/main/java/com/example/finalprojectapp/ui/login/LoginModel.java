package com.example.finalprojectapp.ui.login;

import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;

public class LoginModel implements LoginAdapter.Model{
    private LoginAdapter.Presenter loginPresenter;
    private ManagementAccessPort.SignIn signInRepository;
    public LoginModel(LoginAdapter.Presenter loginPresenter, ManagementAccessPort.SignIn signInRepository) {
        this.loginPresenter = loginPresenter;
        this.signInRepository = signInRepository;
    }

    @Override
    public void onSignIn(User user) {
        this.signInRepository.signIn(user, new ManagementAccessPort.StatusAccess() {
            @Override
            public void success(User user) {
                LoginModel.this.loginPresenter.onSignComplete();
            }
            @Override
            public void failed() {
                LoginModel.this.loginPresenter.onSignFailed();
            }
        });
    }
}
