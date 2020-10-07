package com.example.finalprojectapp.utils.navigateActions;
import android.app.Activity;
import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigateActionController {

    private Activity activity;
    private BottomNavigationView bottomNavigationView;

    public  BottomNavigateActionController(Activity activity,int idBottomNavigationView, int defaultSelectedId){
            this.activity = activity;
            this.bottomNavigationView = (BottomNavigationView)this.activity.findViewById(idBottomNavigationView);
            this.bottomNavigationView.setSelectedItemId(defaultSelectedId);
    }

    public void setOnClickItems(BottomNavigationView.OnNavigationItemSelectedListener listener) {
        this.bottomNavigationView.setOnNavigationItemSelectedListener(listener);
    }

    public <T> void setActivity(Class<T> screenActivity) {
        Intent intent = new Intent(this.activity,screenActivity);
        this.activity.startActivity(intent);
        this.activity.overridePendingTransition(0,0);
    }
}
