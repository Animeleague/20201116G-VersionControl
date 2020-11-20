package com.example.a20201116g_versioncontrol.model.registrationsInformation;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class RegistrationsInformationProcessor {

    String json;
    ArrayList<RegistrationsInformationModel> registrationsInformationModelArrayList;

    public RegistrationsInformationProcessor(String json) {
        this.json = json;
        processData();

    }

    public ArrayList<RegistrationsInformationModel> getRegistrationsInformationModelArrayList() {
        return this.registrationsInformationModelArrayList;
    }

    public void processData() {

        ArrayList<RegistrationsInformationModel> newArray = new ArrayList<RegistrationsInformationModel>();

        if (this.json != null) {

            try {

                JSONArray jsonArray = new JSONArray(this.json);

                for (int i = 0; i < jsonArray.length(); i++) {

                    RegistrationsInformationModel registrationsInformationModel = new RegistrationsInformationModel();
                    JSONObject jsonObject = (JSONObject) jsonArray.getJSONObject(i);

                    // Now make a registrations object and add the data to it
                    Integer eventID = (Integer) jsonObject.getInt("eventID");
                    String eventUniqueCode = (String) jsonObject.getString("eventUniqueCode");
                    String eventLocationCode = (String) jsonObject.getString("eventLocationCode");
                    String eventWebsite = (String) jsonObject.getString("eventWebsite");
                    String eventName = (String) jsonObject.getString("eventName");
                    String eventNameLong = (String) jsonObject.getString("eventNameLong");
                    String eventAddress = (String) jsonObject.getString("eventAddress");
                    String eventPaymentDeadline = (String) jsonObject.getString("eventPaymentDeadline");
                    String eventDatesString = (String) jsonObject.getString("eventDatesString");
                    String eventStartDate = (String) jsonObject.getString("eventStartDate");
                    String eventEndDate = (String) jsonObject.getString("eventEndDate");

                    String eventHasFullEntryString = (String) jsonObject.getString("eventHasFullEntry");
                    String eventHasFridayString = (String) jsonObject.getString("eventHasFriday");
                    String eventHasSaturdayString = (String) jsonObject.getString("eventHasSaturday");
                    String eventVIPStatusString = (String) jsonObject.getString("eventVIPStatus");
                    Boolean eventHasFullEntry = false;
                    Boolean eventHasFriday = false;
                    Boolean eventHasSaturday = false;
                    Boolean eventVIPStatus = false;

                    if (eventHasFullEntryString.equals("1")) { eventHasFullEntry = true; }
                    if (eventHasFridayString.equals("1")) { eventHasFriday = true; }
                    if (eventHasSaturdayString.equals("1")) { eventHasSaturday = true; }
                    if (eventVIPStatusString.equals("1")) { eventVIPStatus = true; }

                    Double eventCostFullEntry = (Double) jsonObject.getDouble("eventCostFullEntry");
                    Double eventCostFriday = (Double) jsonObject.getDouble("eventCostFriday");
                    Double eventCostSaturday = (Double) jsonObject.getDouble("eventCostSaturday");
                    Double eventCostSunday = (Double) jsonObject.getDouble("eventCostSunday");
                    Double eventTShirtCost = (Double) jsonObject.getDouble("eventTShirtCost");
                    Double eventMaskCost = (Double) jsonObject.getDouble("eventMaskCost");
                    Double eventCostPriority = (Double) jsonObject.getDouble("eventCostPriority");
                    Double eventVIPCost = (Double) jsonObject.getDouble("eventVIPCost");

                    // Set all the variables to the new object
                    registrationsInformationModel.setEventID(eventID);
                    registrationsInformationModel.setEventUniqueCode(eventUniqueCode);
                    registrationsInformationModel.setEventLocationCode(eventLocationCode);
                    registrationsInformationModel.setEventWebsite(eventWebsite);
                    registrationsInformationModel.setEventName(eventName);
                    registrationsInformationModel.setEventNameLong(eventNameLong);
                    registrationsInformationModel.setEventAddress(eventAddress);
                    registrationsInformationModel.setEventPaymentDeadline(eventPaymentDeadline);
                    registrationsInformationModel.setEventDatesString(eventDatesString);
                    registrationsInformationModel.setEventStartDate(eventStartDate);
                    registrationsInformationModel.setEventEndDate(eventEndDate);
                    registrationsInformationModel.setEventHasFullEntry(eventHasFullEntry);
                    registrationsInformationModel.setEventHasFriday(eventHasFriday);
                    registrationsInformationModel.setEventHasSaturday(eventHasSaturday);
                    registrationsInformationModel.setEventVIPStatus(eventVIPStatus);
                    registrationsInformationModel.setEventCostFullEntry(eventCostFullEntry);
                    registrationsInformationModel.setEventCostFriday(eventCostFriday);
                    registrationsInformationModel.setEventCostSaturday(eventCostSaturday);
                    registrationsInformationModel.setEventCostSunday(eventCostSunday);
                    registrationsInformationModel.setEventTShirtCost(eventTShirtCost);
                    registrationsInformationModel.setEventMaskCost(eventMaskCost);
                    registrationsInformationModel.setEventCostPriority(eventCostPriority);
                    registrationsInformationModel.setEventVIPCost(eventVIPCost);

                    // Add
                    newArray.add(registrationsInformationModel);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        // Save the data to the array in thic class
        this.registrationsInformationModelArrayList = newArray;
    }

}
