package com.example.a20201116g_versioncontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.a20201116g_versioncontrol.model.registrationsInformation.RegistrationsInformationController;
import com.example.a20201116g_versioncontrol.model.version.VersionController;
import com.example.a20201116g_versioncontrol.model.version.VersionModel;
import com.example.a20201116g_versioncontrol.model.version.VersionProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private Context applicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        this.applicationContext = getApplicationContext();
        checkServerData();

        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkServerData();
        finish();
    }

    public void checkServerData() {

        RegistrationsInformationController registrationsInformationController = new RegistrationsInformationController();


        TaskCheckVersions taskCheckVersions = new TaskCheckVersions();

        try {
            taskCheckVersions.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private class TaskCheckVersions extends AsyncTask<String, String, String> {

        String masterResult = "";

        public TaskCheckVersions() {

        }

        @Override
        protected String doInBackground(String... params) {

            String text = "";
            BufferedReader reader = null;

            try {

                URL url = new URL("https://www.animeleague.app/almobile/versioning.php");
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.flush();

                // Get the server response
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    // Append server response in string
                    sb.append(line + "\n");
                }

                text = sb.toString();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            this.masterResult = text;
            return text;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // The result should be a json. Check its not null/empty first

            if (result.isEmpty() || result == "" || result == null) {
                // Null value so display an error message on the screen to the user.
            } else {
                // It was accepted. We should have a JSON with values. Process and check if the data is valid
                VersionProcessor versionProcessor = new VersionProcessor(result);

                // Get the data model object, and save to system memory
                VersionModel newVersionModel = versionProcessor.getVersionModel();

                // Now initialise the controller, check the result on the app matches the result on the server
                VersionController versionController = new VersionController(applicationContext);

                /************************************************************************
                 *
                 *   VERSIONS DON'T MATCH. UPDATE THE DATA!
                 *
                 ************************************************************************/

                if (!versionController.getRegistrationsVersion().equals(newVersionModel.getRegistrationsVersion()) ) {
                    versionController.setData(newVersionModel);
                    // Now update the registrations data object

                    TaskRegistrationsInformation taskRegistrationsInformation = new TaskRegistrationsInformation();
                    try {
                        //taskRegistrationsInformation.execute();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }
        }
    } // End Class ASyncTask TaskCheckVersions

    private class TaskRegistrationsInformation extends AsyncTask<String, String, String> {

        String masterResult = "";

        public TaskRegistrationsInformation() {

        }

        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String result) {

        }

    } // End Class ASyncTask TaskCheckVersions

    /* TEMPLATE AsyncTask
    private class TaskCheckVersions extends AsyncTask<String, String, String> {

        String masterResult = "";

        public TaskCheckVersions() {

        }

        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String result) {

        }

    } // End Class ASyncTask TaskCheckVersions
     */


}