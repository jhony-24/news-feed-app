package com.example.finalprojectapp.ui.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.ui.news.NewsActivity;
import com.example.finalprojectapp.ui.profile.ProfileActivity;
import com.example.finalprojectapp.common.helpers.BottomNavigateActionController;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        BottomNavigateActionController bottomNavigate = new BottomNavigateActionController(
                this,
                R.id.bottomNavigation,
                R.id.page_settings);
        bottomNavigate.setOnClickItems((MenuItem menuItem)->{
            switch (menuItem.getItemId()) {
                case R.id.page_feeds:
                    bottomNavigate.setActivity(NewsActivity.class);
                    return true;
                case R.id.page_profile:
                    bottomNavigate.setActivity(ProfileActivity.class);
                    return true;
                case R.id.page_settings:
                    return true;
            }
            return false;
        });
    }
}