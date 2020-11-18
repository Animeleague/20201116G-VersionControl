package com.example.a20201116g_versioncontrol;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a20201116g_versioncontrol.model.version.VersionController;

public class HomeActivity extends AppCompatActivity {

    private Context applicationContext;
    private VersionController versionController;

    private TextView helloWorld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationContext = getApplicationContext();

        setContentView(R.layout.home_activity);
        helloWorld = (TextView) findViewById(R.id.helloWorld);

        this.versionController = new VersionController(applicationContext);
        this.helloWorld.setText("Version: " + this.versionController.getRegistrationsVersion().toString());

    }

    @Override
    public void onBackPressed() {
        exitApplication();
    }

    public void exitApplication() {
        finish();
    }


}
