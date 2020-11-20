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
        hasData = false;

        //registrationsInformationModelList = new ArrayList<RegistrationsInformationModel>();
        registrationsJson = readRegistrationsJson();

        if (registrationsJson == null || registrationsJson.isEmpty() || registrationsJson.equals("")) {
            // Empty! We have no data on the file system. Do nothing
        } else {
            // We have data! Process it
            registrationsInformationModelList = getRegistrationsArray(registrationsJson);
            hasData = true;
        }

    }

    public RegistrationsInformationController(Context applicationContext, String registrationsJson) {
        this.applicationContext = applicationContext;
        this.registrationsJson = registrationsJson;
        setRegistrationsJson(this.registrationsJson);
        hasData = false;

        if (registrationsJson.isEmpty() || registrationsJson.equals("")) {
            // Empty! We have no data on the file system. Do nothing
        } else {
            // We have data! Process it
            registrationsInformationModelList = getRegistrationsArray(registrationsJson);
            hasData = true;
        }
    }

    public Boolean getHasData() {
        return hasData;
    }

    public void setRegistrationsJson(String registrationsJson) {

        this.registrationsJson = registrationsJson;
        writeRegistrationsJson(registrationsJson);
        registrationsInformationModelList = getRegistrationsArray(registrationsJson);

    }

    public ArrayList getRegistrationsArray(String registrationsJson) {

        // New & Blank ArrayList for storing the result
        ArrayList<RegistrationsInformationModel> newRegistrationsInformation;

        // Process the json, get an ArrayList
        RegistrationsInformationProcessor registrationsInformationProcessor = new RegistrationsInformationProcessor(registrationsJson);
        return registrationsInformationProcessor.getRegistrationsInformationModelArrayList();

    }

    public ArrayList<String> getListEventCodes() {

        ArrayList<String> arrayList = new ArrayList<String>();

        if (hasData == true) {
            for (int i = 0; i < registrationsInformationModelList.size(); i++) {
                String dataToAdd = registrationsInformationModelList.get(i).getEventUniqueCode();
                arrayList.add(dataToAdd);
            }
        }

        return arrayList;
    }

    public String getRegistrationsJson() {
        return registrationsJson;
    }

    // List of Active Event Codes. We need these so we can process and get values for each unique event
    public List getUniqueCode() {
        return null;
    }

    // Get a value for a unique event
    public String getInformationString(String dataRequest, String eventCode) {
        // Take the event code, process the array until we find it, then get the eventName from the object
        String returnData = "";

        if (hasData == true) {

            for (int i = 0; i < registrationsInformationModelList.size(); i++) {
                if (registrationsInformationModelList.get(i).getEventUniqueCode().equals(eventCode)) {

                    switch (dataRequest) {
                        case "eventUniqueCode":
                            returnData = registrationsInformationModelList.get(i).getEventUniqueCode();
                            break;
                        case "eventLocationCode":
                            returnData = registrationsInformationModelList.get(i).getEventLocationCode();
                            break;
                        case "eventWebsite":
                            returnData = registrationsInformationModelList.get(i).getEventWebsite();
                            break;
                        case "eventName":
                            returnData = registrationsInformationModelList.get(i).getEventName();
                            break;
                        case "eventNameLong":
                            returnData = registrationsInformationModelList.get(i).getEventNameLong();
                            break;
                        case "eventAddress":
                            returnData = registrationsInformationModelList.get(i).getEventAddress();
                            break;
                        case "eventPaymentDeadline":
                            returnData = registrationsInformationModelList.get(i).getEventPaymentDeadline();
                            break;
                        case "eventDatesString":
                            returnData = registrationsInformationModelList.get(i).getEventDatesString();
                            break;
                        case "eventStartDate":
                            returnData = registrationsInformationModelList.get(i).getEventStartDate();
                            break;
                        case "eventEndDate":
                            returnData = registrationsInformationModelList.get(i).getEventEndDate();
                            break;
                        default:
                            returnData = "";
                            break;
                    }
                }
            }
        }
        return returnData;
    }


    public void writeRegistrationsJson(String registrationsJson) {
        // A new JSON has been received from the server. Set this to the app storage.
        try {
            FileOutputStream fileOutputStream = applicationContext.openFileOutput("RegistrationsInformation", Context.MODE_PRIVATE);
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

            FileInputStream fileInputStream = applicationContext.openFileInput("RegistrationsInformation");
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
