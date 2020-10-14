package com.example.finalprojectapp.ui.profile;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.finalprojectapp.R;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.repositories.PersistUserAccountRepository;
import com.example.finalprojectapp.ui.news.NewsActivity;
import com.example.finalprojectapp.ui.settings.SettingsActivity;
import com.example.finalprojectapp.common.helpers.BottomNavigateActionController;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity implements ProfileAdapter.View {
    CircleImageView profileImageViewAvatar;
    ProfileAdapter.Presenter presenter;
    TextView profileFullName, profileEmail,profileDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.profileFullName = (TextView)findViewById(R.id.profileFullName);
        this.profileEmail = (TextView)findViewById(R.id.profileEmail);
        this.profileDescription = (TextView)findViewById(R.id.profileDescription);
        this.profileImageViewAvatar = (CircleImageView) findViewById(R.id.profileAvatar);

        this.presenter = new ProfilePresenter(this);
        this.getUserId();

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

    private void getUserId() {
        PersistUserAccountRepository persistUserAccountRepository = new PersistUserAccountRepository(this);
        this.presenter.onLoadUserProfile(persistUserAccountRepository.getPersistValue("id"));
    }

    @Override
    public void loading() {

    }

    @Override
    public void success() {

    }

    @Override
    public void showUserProfile(User user) {
        this.profileFullName.setText(user.getFullName());
        this.profileEmail.setText(user.getEmail());
        this.profileDescription.setText(user.getDescription());
        Picasso.get().load("https://cdn.pixabay.com/photo/2020/09/13/04/13/coffee-5567269_960_720.jpg").into(this.profileImageViewAvatar);
    }
}