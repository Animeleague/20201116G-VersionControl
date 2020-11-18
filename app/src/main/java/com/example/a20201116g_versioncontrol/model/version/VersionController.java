package com.example.a20201116g_versioncontrol.model.version;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.content.Context.MODE_PRIVATE;

public class VersionController {

    VersionModel versionModel;
    Context applicationContext;

    public VersionController(Context applicationContext) {
        this.applicationContext = applicationContext;
        this.versionModel = readVersionData();

    }

    public VersionController(Context applicationContext, VersionModel versionModel) {
        this.applicationContext = applicationContext;
        this.versionModel = versionModel;
        writeData(this.versionModel);
    }

    public void setData(VersionModel versionModel) {
        this.versionModel = versionModel;
        writeData(this.versionModel);
    }

    public Integer getRegistrationsVersion() {
        return this.versionModel.getRegistrationsVersion();
    }

    public void setRegistrationsVersion(Integer registrationsVersion) {
        this.versionModel.setRegistrationsVersion(registrationsVersion);
        writeData(this.versionModel);
    }

    public void writeData(VersionModel versionModel) {
        try {
            FileOutputStream fileOutputStream = applicationContext.openFileOutput("VersionInformation", MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(versionModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public VersionModel readVersionData() {

        VersionModel versionModel = new VersionModel();
        try {
            FileInputStream fileInputStream = applicationContext.openFileInput("VersionInformation");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            versionModel = (VersionModel) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return versionModel;

    }

    public Context getApplicationContext() { return this.applicationContext; }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

}
