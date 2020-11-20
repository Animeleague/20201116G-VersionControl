package com.example.a20201116g_versioncontrol.model.registrationsInformation;

import android.content.Context;
import android.util.Log;

import com.example.a20201116g_versioncontrol.model.registrationsInformation.RegistrationsInformationModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RegistrationsInformationController {

    Context applicationContext;
    String registrationsJson;
    Boolean hasData;

    ArrayList<RegistrationsInformationModel> registrationsInformationModelList;

    public RegistrationsInformationController(Context applicationContext) {

        this.applicationContext = applicationContext;
        this.hasData = false;

        //registrationsInformationModelList = new ArrayList<RegistrationsInformationModel>();
        this.registrationsJson = readRegistrationsJson();

        if (this.registrationsJson.isEmpty() || this.registrationsJson.equals("")) {
            // Empty! We have no data on the file system. Do nothing
        } else {
            // We have data! Process it
            this.registrationsInformationModelList = getRegistrationsArray(this.registrationsJson);
            this.hasData = true;
        }

    }

    public Boolean getHasData() {
        return this.hasData;
    }

    public void setRegistrationsJson(String registrationsJson) {

        this.registrationsJson = registrationsJson;
        writeRegistrationsJson(this.registrationsJson);
        this.registrationsInformationModelList = getRegistrationsArray(this.registrationsJson);

    }

    public ArrayList getRegistrationsArray(String registrationsJson) {

        // New & Blank ArrayList for storing the result
        ArrayList<RegistrationsInformationModel> newRegistrationsInformation;

        // Process the json, get an ArrayList
        RegistrationsInformationProcessor registrationsInformationProcessor = new RegistrationsInformationProcessor(registrationsJson);
        return registrationsInformationProcessor.getRegistrationsInformationModelArrayList();

    }

    // List of Active Event Codes. We need these so we can process and get values for each unique event
    public List getUniqueCode() {
        return null;
    }

    // Get a value for a unique event
    public String getEventName(String eventCode) {
        // Take the event code, process the array until we find it, then get the eventName from the object

        //RegistrationsInformationModel registrationsInformationModel = new RegistrationsInformationModel();
        //registrationsInformationModelList.add(registrationsInformationModel);
        //Log.d("Array Size: ", String.valueOf(registrationsInformationModelList.size()));
        //registrationsInformationModelList.get(0).setEventUniqueCode("TEST Code");
        //Log.d("Array Code: ", registrationsInformationModelList.get(0).getEventUniqueCode());

        return null;
    }


    public void writeRegistrationsJson(String registrationsJson) {
        // A new JSON has been received from the server. Set this to the app storage.
        try {
            FileOutputStream fileOutputStream = this.applicationContext.openFileOutput("RegistrationsInformation", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(registrationsJson);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String readRegistrationsJson() {
        // Get the JSON from app storage.
        String registrationsJson = "";
        try {

            FileInputStream fileInputStream = this.applicationContext.openFileInput("RegistrationsInformation");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            registrationsJson = (String) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registrationsJson;
    }



}
