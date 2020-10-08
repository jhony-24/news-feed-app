package com.example.finalprojectapp.ui.login;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.finalprojectapp.R;
import com.example.finalprojectapp.ui.news.NewsActivity;
import com.example.finalprojectapp.ui.forget.ForgetPasswordActivity;
import com.example.finalprojectapp.ui.signUp.SignUpActivity;
import com.example.finalprojectapp.common.helpers.NavigateScreen;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class LoginActivity extends AppCompatActivity implements LoginAdapter.View{
    TextInputEditText loginEditTextEmail,loginEditTextPassword;
    MaterialTextView loginProgressTextSignIn;

    ProgressBar loginProgressBarSignIn;
    LoginAdapter.Presenter presenterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.loginEditTextEmail = (TextInputEditText) findViewById(R.id.loginEditTextEmail);
        this.loginEditTextPassword = (TextInputEditText) findViewById(R.id.loginEditTextPassword);
        this.loginProgressBarSignIn = (ProgressBar)findViewById(R.id.loginProgressBarSignIn);
        this.loginProgressTextSignIn = (MaterialTextView)findViewById(R.id.loginProgressTextSignIn);
        this.presenterLogin = new LoginPresenter(this);
    }

    public void onNavigateToSignUp(View view) {
        new NavigateScreen().navigate(this,SignUpActivity.class).opacityAnimation();
    }

    public void onNavigateToForgetPassword(View view) {
        new NavigateScreen().navigate(this,ForgetPasswordActivity.class);
    }

    public void onSignIn(View view) {
        this.presenterLogin.onSignIn(this.loginEditTextEmail.getText().toString(),this.loginEditTextPassword.getText().toString());
    }

    @Override
    public void emptyFields() {
        Toast.makeText(this,"Complete all fields",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loading() {
        this.loginProgressTextSignIn.setText(R.string.common_text_loading_verify);
        this.loginProgressBarSignIn.setVisibility(View.VISIBLE);
    }

    @Override
    public void success() {
        this.loginProgressTextSignIn.setText(R.string.login_text_sign_in);
        this.loginProgressBarSignIn.setVisibility(View.GONE);
    }

    @Override
    public void navigateToMainApplication() {
        new NavigateScreen().navigate(this, NewsActivity.class).fadeFromLeft();
        finish();
    }
}