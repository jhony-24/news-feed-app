package com.example.finalprojectapp.ui.profile;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.ui.news.NewsActivity;
import com.example.finalprojectapp.ui.settings.SettingsActivity;
import com.example.finalprojectapp.utils.navigateActions.BottomNavigateActionController;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    CircleImageView profileImageViewAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.profileImageViewAvatar = (CircleImageView) findViewById(R.id.profileImageViewAvatar);
        Picasso.get().load("https://cdn.pixabay.com/photo/2020/09/13/04/13/coffee-5567269_960_720.jpg").into(this.profileImageViewAvatar);

        BottomNavigateActionController bottomNavigate = new BottomNavigateActionController(
                this,
                R.id.bottomNavigation,
                R.id.page_profile);
        bottomNavigate.setOnClickItems((MenuItem menuItem)->{
            switch (menuItem.getItemId()) {
                case R.id.page_feeds:
                    bottomNavigate.setActivity(NewsActivity.class);
                    return true;
                case R.id.page_profile:
                    return true;
                case R.id.page_settings:
                    bottomNavigate.setActivity(SettingsActivity.class);
                    return true;
            }
            return false;
        });
    }

    public void onGoBackFromProfile(View view){
        onBackPressed();
    }
}