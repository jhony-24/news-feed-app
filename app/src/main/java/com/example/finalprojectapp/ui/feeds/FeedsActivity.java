package com.example.finalprojectapp.ui.feeds;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.common.listViews.ListViewNewsFeedPublished;
import com.example.finalprojectapp.data.entities.NewPost;
import com.example.finalprojectapp.ui.profile.ProfileActivity;
import com.example.finalprojectapp.ui.settings.SettingsActivity;
import com.example.finalprojectapp.utils.navigateActions.BottomNavigateActionController;

import java.util.ArrayList;

public class FeedsActivity extends AppCompatActivity {
    private EditText editTextNewMessagePost;
    private ListView listViewNewsFeed;
    private ListViewNewsFeedPublished listViewNewsFeedPublished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        this.editTextNewMessagePost = (EditText)findViewById(R.id.editTextNewMessagePost);
        this.listViewNewsFeed = (ListView)findViewById(R.id.listViewNewsFeed);
        this.listViewNewsFeedPublished = new ListViewNewsFeedPublished(this,GetItems());


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

    public void onPublishNewPost(View view) {

    }
}