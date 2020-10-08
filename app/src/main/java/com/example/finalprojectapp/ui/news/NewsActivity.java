package com.example.finalprojectapp.ui.news;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.common.listViews.ListViewNewsFeedPublished;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.ui.profile.ProfileActivity;
import com.example.finalprojectapp.ui.settings.SettingsActivity;
import com.example.finalprojectapp.common.helpers.ComposeAnimations;
import com.example.finalprojectapp.common.helpers.BottomNavigateActionController;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    private EditText editTextNewMessagePost;
    private ListView listViewNewsFeed;
    private ListViewNewsFeedPublished listViewNewsFeedPublishedAdapter;
    private ImageButton newsImageButtonSearch;
    private LinearLayout newsLinearLayoutContainerSearchNews;
    private TextView newsTextViewCancelSearchNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        this.editTextNewMessagePost = (EditText) findViewById(R.id.editTextNewMessagePost);
        this.listViewNewsFeed = (ListView)findViewById(R.id.listViewNewsFeed);
        this.newsImageButtonSearch = (ImageButton)findViewById(R.id.newsImageButtonSearch);
        this.newsLinearLayoutContainerSearchNews = (LinearLayout)findViewById(R.id.newsLinearLayoutContainerSearchNews);
        this.newsTextViewCancelSearchNews = (TextView)findViewById(R.id.newsTextViewCancelSearchNews);

        this.listViewNewsFeedPublishedAdapter = new ListViewNewsFeedPublished(this,GetItems());
        this.listViewNewsFeed.setAdapter(this.listViewNewsFeedPublishedAdapter);

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

        this.controlAppearanceContainerSearchNewsFeed();
    }

    private ArrayList<NewPost> GetItems() {
        ArrayList<NewPost> posts = new ArrayList<>();
        posts.add(new NewPost("https://cdn.pixabay.com/photo/2019/12/12/07/01/beomeosa-temple-4689959_960_720.jpg","Juan mark","today","Hola"));
        posts.add(new NewPost("https://cdn.pixabay.com/photo/2019/12/12/07/01/beomeosa-temple-4689959_960_720.jpg","Juan mark","today","Hola"));
        posts.add(new NewPost("https://cdn.pixabay.com/photo/2019/12/12/07/01/beomeosa-temple-4689959_960_720.jpg","Juan mark","today","Hola"));
        posts.add(new NewPost("https://cdn.pixabay.com/photo/2019/12/12/07/01/beomeosa-temple-4689959_960_720.jpg","Juan mark","today","Hola"));
        posts.add(new NewPost("https://cdn.pixabay.com/photo/2019/12/12/07/01/beomeosa-temple-4689959_960_720.jpg","Juan mark","today","Hola"));
        posts.add(new NewPost("https://cdn.pixabay.com/photo/2019/12/12/07/01/beomeosa-temple-4689959_960_720.jpg","Juan mark","today","Hola"));
        posts.add(new NewPost("https://cdn.pixabay.com/photo/2019/12/12/07/01/beomeosa-temple-4689959_960_720.jpg","Juan mark","today","Hola"));
        return posts;
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
}