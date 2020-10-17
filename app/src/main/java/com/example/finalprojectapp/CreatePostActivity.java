package com.example.finalprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.finalprojectapp.common.helpers.NavigateScreen;
import com.example.finalprojectapp.ui.profile.ProfileActivity;

public class CreatePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
    }

    public void onGoBackFromCreatePost(View view) {
        onBackPressed();
    }

    public void onNavigateToProfileFromCreatePost(View view){
        new NavigateScreen().navigate(this,ProfileActivity.class);
    }
}