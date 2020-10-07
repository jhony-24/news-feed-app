package com.example.finalprojectapp.ui.signUp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.ui.login.LoginActivity;
import com.example.finalprojectapp.utils.navigateActions.NavigateScreen;
import com.google.android.material.button.MaterialButton;

public class SignUpActivity extends AppCompatActivity implements SignUpAdapter.View, View.OnClickListener{
    private ProgressBar signUpProgressBarCreate;
    private SignUpAdapter.Presenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        MaterialButton signUpButtonCreate = (MaterialButton) findViewById(R.id.signUpButtonCreate);
        MaterialButton signUpButtonCancel = (MaterialButton) findViewById(R.id.signUpButtonCancel);

        this.signUpProgressBarCreate = (ProgressBar)findViewById(R.id.signInProgressBarCreate);
        this.signUpPresenter = new SignUpPresenter(this);

        signUpButtonCreate.setOnClickListener(this);
        signUpButtonCancel.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUpButtonCancel:
                this.signUpPresenter.onSignUpCancel();
                break;
            case R.id.signUpButtonCreate:
                this.signUpPresenter.onSignUpAction(null);
                break;
        }
    }

    @Override
    public void cancelSignUp() {
        new NavigateScreen().navigate(this, LoginActivity.class);
    }

    public void onNavigateToSignIn(View view) {
        new NavigateScreen().navigate(this, LoginActivity.class);
    }
}