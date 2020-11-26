package com.example.a20201116g_versioncontrol;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a20201116g_versioncontrol.model.registrationsInformation.RegistrationsInformationController;
import com.example.a20201116g_versioncontrol.model.version.VersionController;

public class HomeActivity extends AppCompatActivity {

    private Context applicationContext;
    private VersionController versionController;
    private RegistrationsInformationController registrationsInformationController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationContext = getApplicationContext();

        setContentView(R.layout.home_activity);

        versionController = new VersionController(applicationContext);
        registrationsInformationController = new RegistrationsInformationController(applicationContext);

        // If we want to see test data...
        //OutputTest outputTest = new OutputTest(applicationContext);



    }

    @Override
    public void onBackPressed() {
        exitApplication();
    }

    public void exitApplication() {
        finish();
    }


}
