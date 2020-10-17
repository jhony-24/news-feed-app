package com.example.finalprojectapp.ui.toPost;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.common.helpers.NavigateScreen;
import com.example.finalprojectapp.ui.profile.ProfileActivity;

public class CreatePostActivity extends AppCompatActivity implements  CreatePostAdapter.View{
    EditText createPostMessage;
    Button createPostButton;
    CreatePostAdapter.Presenter createPostPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        this.createPostMessage = (EditText)findViewById(R.id.createPostMessage);
        this.createPostButton = (Button)findViewById(R.id.createPostButton);
        this.createPostPresenter = new CreatePostPresenter(this);
        this.init();
    }

    private void init(){
        this.createPostMessage.setOnClickListener(view -> {

        });
    }

    public void onGoBackFromCreatePost(View view) {
        onBackPressed();
    }

    public void onNavigateToProfileFromCreatePost(View view){
        new NavigateScreen().navigate(this,ProfileActivity.class);
    }
}