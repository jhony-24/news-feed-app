package com.example.finalprojectapp.ui.signUp;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;

public class SignUpModel implements SignUpAdapter.Model {
    private SignUpAdapter.Presenter signUpPresenter;
    private ManagementAccessPort.SignUp signUpRepository;
    public SignUpModel(SignUpAdapter.Presenter signUpPresenter,ManagementAccessPort.SignUp signUpRepository) {
        this.signUpPresenter = signUpPresenter;
        this.signUpRepository = signUpRepository;
    }

    @Override
    public void onSignUp(User user) {
        this.signUpRepository.signUp(user, new ManagementAccessPort.StatusAccess() {
            @Override
            public void success(User user) {
                SignUpModel.this.signUpPresenter.onSignUpComplete();
            }
            @Override
            public void failed(){
                SignUpModel.this.signUpPresenter.onSignUpCancel();
            }
        });
    }
}
