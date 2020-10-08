package com.example.finalprojectapp.common.helpers;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.finalprojectapp.R;

public class ComposeAnimations {

    public static Animation opacity(Context context) {
        return AnimationUtils.loadAnimation(context,R.anim.opacity_animation);
    }

    public static Animation fadeFromLeft(Context context) {
        return AnimationUtils.loadAnimation(context,R.anim.fade_from_left_animation);
    }
}
