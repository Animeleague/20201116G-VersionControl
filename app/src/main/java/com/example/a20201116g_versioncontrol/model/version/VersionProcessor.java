package com.example.a20201116g_versioncontrol.model.version;

import org.json.JSONArray;
import org.json.JSONObject;

public class VersionProcessor {

    String json;

    VersionModel versionModel;

    Integer registrationsVersion;

    public VersionProcessor(String json) {

        this.json = json;
        processData();
    }

    public VersionModel getVersionModel() {
        return this.versionModel;
    }

    public void processData() {

        VersionModel processVersionModel = new VersionModel(0);

        if (this.json != null) {

            try {

                JSONArray jsonArray = new JSONArray(this.json);
                JSONObject jsonObject = jsonArray.getJSONObject(0);

                registrationsVersion = (Integer) jsonObject.getInt("registrationsVersion");

                processVersionModel.setRegistrationsVersion(registrationsVersion);


            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        this.versionModel = processVersionModel;

    }


}
