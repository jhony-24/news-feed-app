package com.example.finalprojectapp.ui.forget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.finalprojectapp.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    public void onResetPassword(View view){

    }

    public void onNavigateToSignIn(View view) {
        onBackPressed();
    }
}