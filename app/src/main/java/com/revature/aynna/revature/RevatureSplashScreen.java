package com.revature.aynna.revature;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class RevatureSplashScreen extends AppCompatActivity {

    private static final String TAG = "Splash Screen";
    private View gifLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revature_splash_screen);
        gifLoading = findViewById(R.id.revatureLoadingGif);
        long SPLASH_SCREEN_TIME = 3000L;
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

        gifLoading.setScaleX(1);
        gifLoading.setScaleX(1);
        gifLoading.animate().scaleX(0).scaleY(0).setDuration(1000).setStartDelay(1000);

    }
}
