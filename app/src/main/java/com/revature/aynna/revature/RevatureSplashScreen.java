package com.revature.aynna.revature;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class RevatureSplashScreen extends AppCompatActivity {

    private static final String TAG = "Splash Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revature_splash_screen);
        View gifLoading = findViewById(R.id.revatureLoadingGif);
        long SPLASH_SCREEN_TIME = 3000L;
        gifLoading.setVisibility(View.GONE);
        gifLoading.animate();
        gifLoading.setVisibility(View.VISIBLE);
        Log.v(TAG, "Width = " + gifLoading.getWidth() + "\nHeight = " + gifLoading.getHeight());


        animate();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                setContentView(R.layout.activity_revature_home);

            }
        }, SPLASH_SCREEN_TIME);

    }

    private void animate() {


    }
}
