package com.example.jh.dnote.dnote.listener;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class MyAnimationListener implements AnimationListener {
    private View view;

    public MyAnimationListener(View view) {
        this.view = view;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        view.clearAnimation();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}
