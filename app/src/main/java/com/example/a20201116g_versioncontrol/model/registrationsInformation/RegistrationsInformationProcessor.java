package com.example.a20201116g_versioncontrol.model.registrationsInformation;

import com.example.a20201116g_versioncontrol.constants.RegistrationsInformationConstants;

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
                    Integer eventID = (Integer) jsonObject.getInt(RegistrationsInformationConstants.EVENT_ID);
                    String eventUniqueCode = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_UNIQUE_CODE);
                    String eventLocationCode = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_LOCATION_CODE);
                    String eventWebsite = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_WEBSITE);
                    String eventName = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_NAME);
                    String eventNameLong = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_NAME_LONG);
                    String eventAddress = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_ADDRESS);
                    String eventPaymentDeadline = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_PAYMENT_DEADLINE);
                    String eventDatesString = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_DATES_STRING);
                    String eventStartDate = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_START_DATE);
                    String eventEndDate = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_END_DATE);

                    String eventHasFullEntryString = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_HAS_FULL_ENTRY);
                    String eventHasFridayString = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_HAS_FRIDAY);
                    String eventHasSaturdayString = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_HAS_SATURDAY);
                    String eventVIPStatusString = (String) jsonObject.getString(RegistrationsInformationConstants.EVENT_VIP_STATUS);
                    Boolean eventHasFullEntry = false;
                    Boolean eventHasFriday = false;
                    Boolean eventHasSaturday = false;
                    Boolean eventVIPStatus = false;

                    if (eventHasFullEntryString.equals("1")) { eventHasFullEntry = true; }
                    if (eventHasFridayString.equals("1")) { eventHasFriday = true; }
                    if (eventHasSaturdayString.equals("1")) { eventHasSaturday = true; }
                    if (eventVIPStatusString.equals("1")) { eventVIPStatus = true; }

                    Double eventCostFullEntry = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_FULL_ENTRY);
                    Double eventCostFriday = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_FRIDAY);
                    Double eventCostSaturday = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_SATURDAY);
                    Double eventCostSunday = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_SUNDAY);
                    Double eventTShirtCost = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_TSHIRT);
                    Double eventMaskCost = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_MASK);
                    Double eventCostPriority = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_PRIORITY);
                    Double eventVIPCost = (Double) jsonObject.getDouble(RegistrationsInformationConstants.EVENT_COST_VIP);

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
