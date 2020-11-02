package com.example.finalprojectapp.ui.toPost;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.common.helpers.NavigateScreen;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.repositories.PersistUserAccountRepository;
import com.example.finalprojectapp.ui.profile.ProfileActivity;

import java.util.Date;

public class CreatePostActivity extends AppCompatActivity implements  CreatePostAdapter.View{
    EditText createPostMessage;
    Button createPostButton;
    CreatePostAdapter.Presenter createPostPresenter;
    PersistUserAccountRepository persistUserAccountRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        this.createPostMessage = (EditText)findViewById(R.id.createPostMessage);
        this.createPostButton = (Button)findViewById(R.id.createPostButton);
        this.createPostPresenter = new CreatePostPresenter(this);
        this.persistUserAccountRepository = new PersistUserAccountRepository(this);
        this.init();
    }

    private void init(){
        this.createPostButton.setEnabled(true);
        this.createPostButton.setOnClickListener(view -> {
            String message = this.createPostMessage.getText().toString();
            NewPost newPost = new NewPost();
            newPost.setFullName(this.persistUserAccountRepository.getPersistValue("fullName"));
            newPost.setMessage(message);
            newPost.setDatetime(new Date().toString());
            this.createPostPresenter.createNewPost(newPost);
        });
    }

    public void onGoBackFromCreatePost(View view) {
        onBackPressed();
    }

    public void onNavigateToProfileFromCreatePost(View view){
        new NavigateScreen().navigate(this,ProfileActivity.class);
    }

    @Override
    public void loading() {

    }

    @Override
    public void success() {
        Toast.makeText(this,"Publicación completada",Toast.LENGTH_SHORT).show();
    }
}