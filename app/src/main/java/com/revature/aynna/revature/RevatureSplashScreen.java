package com.revature.aynna.revature;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RevatureSplashScreen extends AppCompatActivity {

    private static final String TAG = "Splash Screen";
    private View logo;
    private View logIn;
    private View register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revature_splash_screen);
        logIn = findViewById(R.id.logIn);
        register = findViewById(R.id.register);
        logo = findViewById(R.id.revatureLogo);
        long SPLASH_SCREEN_TIME = 3000L;

        logIn.setVisibility(View.INVISIBLE);
        register.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                animate();

            }
        }, SPLASH_SCREEN_TIME);

    }

    private void animate() {

        logo.animate().translationY(-100).setDuration(500).setStartDelay(600);

        logIn.setVisibility(View.VISIBLE);
        register.setVisibility(View.VISIBLE);

        register.animate().translationY(-50).setDuration(500).setStartDelay(500);
        logIn.animate().translationY(-150).setDuration(400).setStartDelay(600);

    }
}
