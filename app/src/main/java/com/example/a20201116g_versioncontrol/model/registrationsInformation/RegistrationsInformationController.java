package com.example.a20201116g_versioncontrol.model.registrationsInformation;

import android.content.Context;

import com.example.a20201116g_versioncontrol.constants.RegistrationsInformationConstants;

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

        if (registrationsJson == null || registrationsJson.isEmpty() || registrationsJson.equals("")) {
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
                        case RegistrationsInformationConstants.EVENT_ID:
                            returnData = (String) registrationsInformationModelList.get(i).getEventUniqueCode();
                            break;
                        case RegistrationsInformationConstants.EVENT_LOCATION_CODE:
                            returnData = (String) registrationsInformationModelList.get(i).getEventLocationCode();
                            break;
                        case RegistrationsInformationConstants.EVENT_WEBSITE:
                            returnData = (String) registrationsInformationModelList.get(i).getEventWebsite();
                            break;
                        case RegistrationsInformationConstants.EVENT_NAME:
                            returnData = (String) registrationsInformationModelList.get(i).getEventName();
                            break;
                        case RegistrationsInformationConstants.EVENT_NAME_LONG:
                            returnData = (String) registrationsInformationModelList.get(i).getEventNameLong();
                            break;
                        case RegistrationsInformationConstants.EVENT_ADDRESS:
                            returnData = (String) registrationsInformationModelList.get(i).getEventAddress();
                            break;
                        case RegistrationsInformationConstants.EVENT_PAYMENT_DEADLINE:
                            returnData = (String) registrationsInformationModelList.get(i).getEventPaymentDeadline();
                            break;
                        case RegistrationsInformationConstants.EVENT_DATES_STRING:
                            returnData = (String) registrationsInformationModelList.get(i).getEventDatesString();
                            break;
                        case RegistrationsInformationConstants.EVENT_START_DATE:
                            returnData = (String) registrationsInformationModelList.get(i).getEventStartDate();
                            break;
                        case RegistrationsInformationConstants.EVENT_END_DATE:
                            returnData = (String) registrationsInformationModelList.get(i).getEventEndDate();
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

    public Integer getInformationInteger(String dataRequest, String eventCode) {

        Integer returnData = 0;

        if (hasData == true) {

            for (int i = 0; i < registrationsInformationModelList.size(); i++) {
                if (registrationsInformationModelList.get(i).getEventUniqueCode().equals(eventCode)) {
                    switch (dataRequest) {
                        case RegistrationsInformationConstants.EVENT_ID:
                            returnData = (Integer) registrationsInformationModelList.get(i).getEventID();
                            break;
                        default:
                            returnData = 0;
                            break;
                    }
                }
            }
        }
        return returnData;
    }

    public Boolean getInformationBoolean(String dataRequest, String eventCode) {

        Boolean returnData = false;

        if (hasData == true) {

            for (int i = 0; i < registrationsInformationModelList.size(); i++) {
                if (registrationsInformationModelList.get(i).getEventUniqueCode().equals(eventCode)) {
                    switch (dataRequest) {
                        case RegistrationsInformationConstants.EVENT_HAS_FULL_ENTRY:
                            returnData = (Boolean) registrationsInformationModelList.get(i).getEventHasFullEntry();
                            break;
                        case RegistrationsInformationConstants.EVENT_HAS_FRIDAY :
                            returnData = (Boolean) registrationsInformationModelList.get(i).getEventHasFriday();
                            break;
                        case RegistrationsInformationConstants.EVENT_HAS_SATURDAY:
                            returnData = (Boolean) registrationsInformationModelList.get(i).getEventHasSaturday();
                            break;
                        case RegistrationsInformationConstants.EVENT_VIP_STATUS:
                            returnData = (Boolean) registrationsInformationModelList.get(i).getEventVIPStatus();
                            break;
                        default:
                            returnData = false;
                            break;
                    }
                }
            }

        }
        return returnData;
    }

    public Double getInformationDouble(String dataRequest, String eventCode) {

        Double returnData = 0.0;

        if (hasData == true) {

            for (int i = 0; i < registrationsInformationModelList.size(); i++) {
                if (registrationsInformationModelList.get(i).getEventUniqueCode().equals(eventCode)) {
                    switch (dataRequest) {
                        case RegistrationsInformationConstants.EVENT_COST_FULL_ENTRY:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventCostFullEntry();
                            break;
                        case RegistrationsInformationConstants.EVENT_COST_FRIDAY:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventCostFriday();
                            break;
                        case RegistrationsInformationConstants.EVENT_COST_SATURDAY:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventCostSaturday();
                            break;
                        case RegistrationsInformationConstants.EVENT_COST_SUNDAY:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventCostSunday();
                            break;
                        case RegistrationsInformationConstants.EVENT_COST_TSHIRT:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventTShirtCost();
                            break;
                        case RegistrationsInformationConstants.EVENT_COST_MASK:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventMaskCost();
                            break;
                        case RegistrationsInformationConstants.EVENT_COST_PRIORITY:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventCostPriority();
                            break;
                        case RegistrationsInformationConstants.EVENT_COST_VIP:
                            returnData = (Double) registrationsInformationModelList.get(i).getEventVIPCost();
                            break;
                        default:
                            returnData = 0.0;
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
