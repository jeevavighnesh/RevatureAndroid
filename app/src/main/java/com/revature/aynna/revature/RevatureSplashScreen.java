package com.revature.aynna.revature;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class RevatureSplashScreen extends AppCompatActivity {


    private static final String TAG = RevatureSplashScreen.class.getName();
    private View logIn;
    private View register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "!!!!Got into The Splash Screen!!!!");
        setContentView(R.layout.activity_revature_splash_screen);
        logIn = findViewById(R.id.logIn);
        register = findViewById(R.id.register);
        long SPLASH_SCREEN_TIME = 600L;

        logIn.setVisibility(View.INVISIBLE);
        register.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                animateOffscreen(logIn, 2f, 3600);
                animateOffscreen(register, 1f, 3600);

            }
        }, SPLASH_SCREEN_TIME);

    }

    private void animateOffscreen(View view, float relativeDistance, int animationDuration) {

//        logo.animate().translationY(-100).setDuration(500).setStartDelay(600);

        view.setVisibility(View.VISIBLE);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0,  // from X
                Animation.RELATIVE_TO_PARENT, 0,  // to X
                Animation.RELATIVE_TO_PARENT, relativeDistance, // from Y
                Animation.RELATIVE_TO_PARENT, 0f); // to Y
        translateAnimation.setDuration(animationDuration); // milliseconds
        view.startAnimation(translateAnimation);

    }

    public void register(View view) {

        Log.v(TAG, "Clicked Register Button");
        Intent register = new Intent(this, Register.class);
        Log.v(TAG, "Starting registration Intent");
        startActivity(register);
    }

    public void logIn(View view) {

        Log.v(TAG, "Clicked LogIn Button");
        Intent logIn = new Intent(this, LogIn.class);
        Log.v(TAG, "Starting LogIn Intent");
        startActivity(logIn);

    }
}
