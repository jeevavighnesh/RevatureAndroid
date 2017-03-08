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
        View bar10 = findViewById(R.id.orangebar_10);
        View bar9 = findViewById(R.id.orangebar_9);
        View bar8 = findViewById(R.id.orangebar_8);
        View bar7 = findViewById(R.id.orangebar_7);
        View bar6 = findViewById(R.id.orangebar_6);
        View bar5 = findViewById(R.id.orangebar_5);
        View bar4 = findViewById(R.id.orangebar_4);
        View bar3 = findViewById(R.id.orangebar_3);
        View bar2 = findViewById(R.id.orangebar_2);
        View bar1 = findViewById(R.id.orangebar_1);

        long SPLASH_SCREEN_TIME = 600L;

        logIn.setVisibility(View.INVISIBLE);
        register.setVisibility(View.INVISIBLE);
//        bar10.setVisibility(View.GONE);
        moveIt(bar1, 10f, -280f, -185f);
        moveIt(bar2, 20f, -280f, -185f);
        moveIt(bar3, 30f, -280f, -185f);
        moveIt(bar4, 40f, -280f, -185f);
        moveIt(bar5, 50f, -280f, -185f);
        moveIt(bar6, 60f, -280f, -185f);
        moveIt(bar7, 70f, -280f, -185f);
        moveIt(bar8, 80f, -290f, -185f);
        Log.v(TAG, "Hai " + bar9.getRotation());
        moveIt(bar9, 90f, -302f, -185f);
        Log.v(TAG, "Hai " + bar9.getRotation());
        moveIt(bar10, 100f, -310f, -187f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                animateOffscreen(logIn, 3f, 1800);
                animateOffscreen(register, 2f, 1800);

            }
        }, SPLASH_SCREEN_TIME);

    }

    private void moveIt(final View view, float endAngle, float rotationStart, float rotationEnd) {

        Log.v(TAG, "Animating star");
        Path path = new Path();
        /*Animation rotate = new RotateAnimation(-210,-180);
        rotate.setDuration(1000);
        rotate.setFillAfter(true);

        view.setAnimation(rotate);*/

        ObjectAnimator rotate = ObjectAnimator.ofFloat(view ,
                "rotation", rotationStart, rotationEnd);
        rotate.setDuration(3000);
        rotate.start();

        path.addArc(130/*left*/, 90/*top*/, 485/*right*/, 300/*bottom*/, -160, endAngle);
        Log.v(TAG, "!!!!Animating star Started!!!!");

        ObjectAnimator curve =
                ObjectAnimator.ofFloat(view, View.X,
                        View.Y, path);

        curve.setDuration(3000);
        Log.v(TAG, "!!!!Animating star DONE!!!!");
        curve.start();
//        AnimatorSet logo = new AnimatorSet();
//        logo.playTogether(curve, rotate);


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
