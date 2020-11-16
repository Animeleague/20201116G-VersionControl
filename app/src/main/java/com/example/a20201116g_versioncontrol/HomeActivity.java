package com.example.a20201116g_versioncontrol;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Context applicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationContext = getApplicationContext();

        setContentView(R.layout.home_activity);


    }

    @Override
    public void onBackPressed() {
        exitApplication();
    }

    public void exitApplication() {
        finish();
    }

}
