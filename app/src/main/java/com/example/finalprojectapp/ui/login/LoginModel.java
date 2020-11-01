package com.example.finalprojectapp.ui.login;

import com.example.finalprojectapp.data.entities.PersistKeyValue;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;
import com.example.finalprojectapp.data.repositories.PersistUserAccountRepository;

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
            public void success(User successUser) {
                LoginModel.this.loginPresenter.onSignComplete(successUser);
            }
            @Override
            public void failed()
            {
                LoginModel.this.loginPresenter.onSignFailed();
            }
        });
    }
}
