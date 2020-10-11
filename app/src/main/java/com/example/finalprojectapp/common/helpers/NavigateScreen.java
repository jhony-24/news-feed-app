package com.example.finalprojectapp.common.helpers;
import android.app.Activity;
import android.content.Intent;
import com.example.finalprojectapp.R;

public class NavigateScreen {
    private Activity activity;
    public <T> NavigateScreen  navigate(Activity contextActivity,Class<T> classActivity){
        activity = contextActivity;
        Intent intent = new Intent(contextActivity,classActivity);
        activity.startActivity(intent);
        return this;
    }

    public void opacityAnimation() {
        activity.overridePendingTransition(R.anim.opacity_animation,R.anim.opacity_animation);
    }

    public void fadeFromLeft(){
        activity.overridePendingTransition(R.anim.fade_from_left_animation,R.anim.fade_from_left_animation);
    }
}
