package com.example.a20201116g_versioncontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }

    public void checkServerData() {

    }

    private class TaskCheckVersions extends AsyncTask<String, String, String> {

        String masterResult = "";

        public TaskCheckVersions() {

        }

        @Override
        protected String doInBackground(String... strings) {
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
        protected String doInBackground(String... strings) {
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