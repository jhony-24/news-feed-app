package com.example.finalprojectapp.ui.feeds;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.example.finalprojectapp.R;
import com.example.finalprojectapp.ui.profile.ProfileActivity;
import com.example.finalprojectapp.ui.settings.SettingsActivity;
import com.example.finalprojectapp.utils.navigateActions.BottomNavigateActionController;

public class FeedsActivity extends AppCompatActivity {
    private EditText editTextNewMessagePost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        this.editTextNewMessagePost = (EditText)findViewById(R.id.editTextNewMessagePost);

        BottomNavigateActionController bottomNavigate = new BottomNavigateActionController(
                this,
                R.id.bottomNavigation,
                R.id.page_feeds);
        bottomNavigate.setOnClickItems((MenuItem menuItem)->{
            switch (menuItem.getItemId()) {
                case R.id.page_feeds:
                    return true;
                case R.id.page_profile:
                    bottomNavigate.setActivity(ProfileActivity.class);
                    return true;
                case R.id.page_settings:
                    bottomNavigate.setActivity(SettingsActivity.class);
                    return true;
            }
            return false;
        });

    }

    public void onPublishNewPost(View view) {

    }
}