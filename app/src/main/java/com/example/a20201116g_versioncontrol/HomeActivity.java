package com.example.a20201116g_versioncontrol;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a20201116g_versioncontrol.model.registrationsInformation.RegistrationsInformationController;
import com.example.a20201116g_versioncontrol.model.version.VersionController;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Context applicationContext;
    private VersionController versionController;
    private RegistrationsInformationController registrationsInformationController;

    private TextView helloWorld;
    private TextView jsonOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationContext = getApplicationContext();

        setContentView(R.layout.home_activity);
        helloWorld = (TextView) findViewById(R.id.helloWorld);
        jsonOutput = (TextView) findViewById(R.id.jsonOutput);

        this.versionController = new VersionController(applicationContext);
        this.helloWorld.setText("Version: " + this.versionController.getRegistrationsVersion().toString());

        this.registrationsInformationController = new RegistrationsInformationController(applicationContext);
        this.jsonOutput.setText(registrationsInformationController.getRegistrationsJson());

        ArrayList<String> arrayList = registrationsInformationController.getListEventCodes();
        for (int i = 0; i < arrayList.size(); i++) {

            String eventName = registrationsInformationController.getInformationString("eventNameLong", arrayList.get(i));
            Log.d("CodeList123: ",arrayList.get(i) + " - " + eventName);

        }


    }

    @Override
    public void onBackPressed() {
        exitApplication();
    }

    public void exitApplication() {
        finish();
    }


}
