package com.example.finalprojectapp.ui.news;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.common.listViews.ListViewNewsFeedPublished;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.data.entities.NewsFeedPublished;
import com.example.finalprojectapp.data.repositories.APIGetNewsFeedRepository;
import com.example.finalprojectapp.data.services.NewsFeedService;
import com.example.finalprojectapp.ui.profile.ProfileActivity;
import com.example.finalprojectapp.ui.settings.SettingsActivity;
import com.example.finalprojectapp.common.helpers.ComposeAnimations;
import com.example.finalprojectapp.common.helpers.BottomNavigateActionController;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity implements  NewsAdapter.View{
    private EditText editTextNewMessagePost;
    private ListView listViewNewsFeed;
    private ImageButton newsImageButtonSearch, newsImageButtonAddNewPost;
    private LinearLayout newsLinearLayoutContainerSearchNews;
    private TextView newsTextViewCancelSearchNews;
    private RelativeLayout newsProgressBarContainerAllData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        this.editTextNewMessagePost = (EditText) findViewById(R.id.editTextNewMessagePost);
        this.listViewNewsFeed = (ListView)findViewById(R.id.listViewNewsFeed);
        this.newsImageButtonSearch = (ImageButton)findViewById(R.id.newsImageButtonSearch);
        this.newsImageButtonAddNewPost = (ImageButton)findViewById(R.id.newsImageButtonAddNewPost);
        this.newsLinearLayoutContainerSearchNews = (LinearLayout)findViewById(R.id.newsLinearLayoutContainerSearchNews);
        this.newsTextViewCancelSearchNews = (TextView)findViewById(R.id.newsTextViewCancelSearchNews);
        this.newsProgressBarContainerAllData = (RelativeLayout) findViewById(R.id.newsProgressBarContainerAllData);

        new MaterialAlertDialogBuilder(this).show(); 

        BottomNavigateActionController bottomNavigate = new BottomNavigateActionController(this, R.id.bottomNavigation, R.id.page_feeds);
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
        this.controlAppearanceContainerSearchNewsFeed();
        this.onLoadNewsFeed();
    }
    public void controlAppearanceContainerSearchNewsFeed() {
        this.newsImageButtonSearch.setOnClickListener((view)-> {
                this.newsLinearLayoutContainerSearchNews.setVisibility(View.VISIBLE);
                this.newsLinearLayoutContainerSearchNews.startAnimation(ComposeAnimations.opacity(this));
        });
        this.newsTextViewCancelSearchNews.setOnClickListener((view)-> {
            this.editTextNewMessagePost.setText("");
            this.newsLinearLayoutContainerSearchNews.setVisibility(View.GONE);
        });
    }

    @Override
    public void loading() {
    }

    @Override
    public void success() {
    }

    @Override
    public void onLoadNewsFeed(ArrayList<NewPost> listNewPost) {

    }

    public void onLoadNewsFeed(){
        this.newsProgressBarContainerAllData.setVisibility(View.VISIBLE);

        APIGetNewsFeedRepository.load(new APIGetNewsFeedRepository.LoadDataCallback() {
            @Override
            public void load(ArrayList<NewsFeedPublished> newsFeedPublished) {
                ListViewNewsFeedPublished listViewNewsFeedPublishedAdapter = new ListViewNewsFeedPublished(getApplicationContext(), newsFeedPublished);
                NewsActivity.this.listViewNewsFeed.setAdapter(listViewNewsFeedPublishedAdapter);
                NewsActivity.this.newsProgressBarContainerAllData.setVisibility(View.GONE);
            }
            @Override
            public void failed() {
                Toast.makeText(getApplicationContext(),"Error network",Toast.LENGTH_SHORT).show();
            }
        });

    }
}