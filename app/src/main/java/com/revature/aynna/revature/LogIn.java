package com.revature.aynna.revature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LogIn extends AppCompatActivity {

    private static final String TAG = Register.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Log.v(TAG, "!!!!Got into Log In Activity!!!!");

    }
}
