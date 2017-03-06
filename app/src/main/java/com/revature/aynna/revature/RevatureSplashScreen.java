package com.revature.aynna.revature;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
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
        View star = findViewById(R.id.star);
        long SPLASH_SCREEN_TIME = 600L;

        logIn.setVisibility(View.INVISIBLE);
        register.setVisibility(View.INVISIBLE);
        moveIt(star);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                animateOffscreen(logIn, 3f, 1800);
                animateOffscreen(register, 2f, 1800);

            }
        }, SPLASH_SCREEN_TIME);

    }

    private void moveIt(final View view) {

        Log.v(TAG, "Animating star");
        float x = 160;
        float y = 380;
        Path path = new Path();
        Log.v(TAG, "x: " + x + "y: " + y);

        path.moveTo(x, y);
        path.addArc(100, 200, 500, 400, -180, 120);
        Log.v(TAG, "Animating star");

        ObjectAnimator objectAnimator =
                ObjectAnimator.ofFloat(view, View.X,
                        View.Y, path);

        objectAnimator.setDuration(3000);
        Log.v(TAG, "Animating star");
        objectAnimator.start();
    }

    private void animateOffscreen(View view, float relativeDistance, int animationDuration) {

        Log.v(TAG, "Animating buttons");
        view.setVisibility(View.VISIBLE);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0,  // from X
                Animation.RELATIVE_TO_PARENT, 0,  // to X
                Animation.RELATIVE_TO_PARENT, relativeDistance, // from Y
                Animation.RELATIVE_TO_PARENT, 0f); // to Y
        translateAnimation.setDuration(animationDuration); // milliseconds
        translateAnimation.start();
        view.startAnimation(translateAnimation);

    }

    public void register(View view) {

        Log.v(TAG, "Clicked Register Button");
        Intent register = new Intent(this, Register.class);
        Log.v(TAG, "Starting registration Intent");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "registerButton");
        startActivity(register, options.toBundle());
    }

    public void logIn(View view) {

        Log.v(TAG, "Clicked LogIn Button");
        Intent logIn = new Intent(this, LogIn.class);
        Log.v(TAG, "Starting LogIn Intent");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "logInButton");
        startActivity(logIn, options.toBundle());

    }
}
