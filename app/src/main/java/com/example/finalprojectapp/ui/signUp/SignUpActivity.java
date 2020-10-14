package com.example.finalprojectapp.ui.signUp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.ui.login.LoginActivity;
import com.example.finalprojectapp.common.helpers.NavigateScreen;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.UUID;

public class SignUpActivity extends AppCompatActivity implements SignUpAdapter.View, View.OnClickListener{
    private  MaterialButton signUpButtonCreate,signUpButtonCancel;
    private RelativeLayout signUpProgressBarCreate;
    private SignUpAdapter.Presenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.signUpButtonCreate = (MaterialButton) findViewById(R.id.signUpButtonCreate);
        this.signUpButtonCancel = (MaterialButton) findViewById(R.id.signUpButtonCancel);
        this.signUpProgressBarCreate = (RelativeLayout)findViewById(R.id.signInProgressBarCreate);
        this.init();
    }

    private void init() {
        this.signUpPresenter = new SignUpPresenter(this);
        signUpButtonCreate.setOnClickListener(this);
        signUpButtonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUpButtonCancel:
                this.signUpPresenter.onSignUpCancel();
                break;
            case R.id.signUpButtonCreate:
                TextInputEditText
                fullName = (TextInputEditText)findViewById(R.id.signUpEditTextFullName),
                email = (TextInputEditText)findViewById(R.id.signUpEditTextEmail),
                password = (TextInputEditText)findViewById(R.id.signUpEditTextPassword),
                passwordVerify = (TextInputEditText)findViewById(R.id.signUpEditTextPasswordVerify);

                User user = new User();
                user.setFullName(String.valueOf(fullName.getText()));
                user.setEmail(String.valueOf(email.getText()));
                user.setPassword(String.valueOf(password.getText()));

                User userVerify = new User();
                userVerify.setPassword(String.valueOf(passwordVerify.getText()));
                this.signUpPresenter.onSignUpAction(user,userVerify);
                break;
        }
    }

    @Override
    public void cancelSignUp() {
        new NavigateScreen().navigate(this, LoginActivity.class);
    }

    @Override
    public void failedMessage() {
        this.signUpProgressBarCreate.setVisibility(View.GONE);
        Toast.makeText(this,"An error has occurred",Toast.LENGTH_SHORT).show();
    }

    public void onNavigateToSignIn(View view) {
        new NavigateScreen().navigate(this, LoginActivity.class);
    }

    @Override
    public void loading() {
        this.signUpProgressBarCreate.setVisibility(View.VISIBLE);
    }

    @Override
    public void success() {
        this.signUpProgressBarCreate.setVisibility(View.GONE);
        Toast.makeText(this,"Estás registrado",Toast.LENGTH_SHORT).show();
    }
}