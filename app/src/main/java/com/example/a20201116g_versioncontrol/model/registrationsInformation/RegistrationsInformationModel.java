package com.example.a20201116g_versioncontrol.model.registrationsInformation;

public class RegistrationsInformationModel {

    private Integer eventID;
    private String eventUniqueCode;
    private String eventLocationCode;
    private String eventWebsite;
    private String eventName;
    private String eventNameLong;
    private String eventAddress;
    private String eventPaymentDeadline;
    private String eventDatesString;
    private String eventStartDate;
    private String eventEndDate;
    private Boolean eventHasFullEntry;
    private Boolean eventHasFriday;
    private Boolean eventHasSaturday;
    private Boolean eventVIPStatus;
    private Double eventCostFullEntry;
    private Double eventCostFriday;
    private Double eventCostSaturday;
    private Double eventCostSunday;
    private Double eventTShirtCost;
    private Double eventMaskCost;
    private Double eventCostPriority;
    private Double eventVIPCost;

    public RegistrationsInformationModel() {

        // We've not yet had any data. We need to initialize the variables with defaults. This prevents null errors.

        // Integer
        eventID = 0;

        // String
        eventUniqueCode = "";
        eventLocationCode = "";
        eventWebsite = "";
        eventName = "";
        eventNameLong = "";
        eventAddress = "";
        eventPaymentDeadline = "";
        eventDatesString = "";
        eventStartDate = "";
        eventEndDate = "";

        // Boolean
        eventHasFullEntry = false;
        eventHasFriday = false;
        eventHasSaturday = false;
        eventVIPStatus = false;

        // Double
        eventCostFullEntry = 0.0;
        eventCostFriday = 0.0;
        eventCostSaturday = 0.0;
        eventCostSunday = 0.0;
        eventTShirtCost = 0.0;
        eventMaskCost = 0.0;
        eventCostPriority = 0.0;
        eventVIPCost = 0.0;

    }

    // Getters
    public Integer getEventID() { return eventID; }
    public String getEventUniqueCode() { return eventUniqueCode; }
    public String getEventLocationCode() { return eventLocationCode; }
    public String getEventWebsite() { return eventWebsite; }
    public String getEventName() { return eventName; }
    public String getEventNameLong() { return eventNameLong; }
    public String getEventAddress() { return eventAddress; }
    public String getEventPaymentDeadline() { return eventPaymentDeadline; }
    public String getEventDatesString() { return eventDatesString; }
    public String getEventStartDate() { return eventStartDate; }
    public String getEventEndDate() { return eventEndDate; }
    public Boolean getEventHasFullEntry() { return eventHasFullEntry; }
    public Boolean getEventHasFriday() { return eventHasFriday; }
    public Boolean getEventHasSaturday() { return eventHasSaturday; }
    public Boolean getEventVIPStatus() { return eventVIPStatus; }
    public Double getEventCostFullEntry() { return eventCostFullEntry; }
    public Double getEventCostFriday() { return eventCostFriday; }
    public Double getEventCostSaturday() { return eventCostSaturday; }
    public Double getEventCostSunday() { return eventCostSunday; }
    public Double getEventTShirtCost() { return eventTShirtCost; }
    public Double getEventMaskCost() { return eventMaskCost; }
    public Double getEventCostPriority() { return eventCostPriority; }
    public Double getEventVIPCost() { return eventVIPCost; }

    // Setters
    public void setEventID(Integer eventID) { this.eventID = eventID; }
    public void setEventUniqueCode(String eventUniqueCode) { this.eventUniqueCode = eventUniqueCode; }
    public void setEventLocationCode(String eventLocationCode) { this.eventLocationCode = eventLocationCode; }
    public void setEventWebsite(String eventWebsite) { this.eventWebsite = eventWebsite; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public void setEventNameLong(String eventNameLong) { this.eventNameLong = eventNameLong; }
    public void setEventAddress(String eventAddress) { this.eventAddress = eventAddress; }
    public void setEventPaymentDeadline(String eventPaymentDeadline) { this.eventPaymentDeadline = eventPaymentDeadline; }
    public void setEventDatesString(String eventDatesString) { this.eventDatesString = eventDatesString; }
    public void setEventStartDate(String eventStartDate) { this.eventStartDate = eventStartDate; }
    public void setEventEndDate(String eventEndDate) { this.eventEndDate = eventEndDate; }
    public void setEventHasFullEntry(Boolean eventHasFullEntry) { this.eventHasFullEntry = eventHasFullEntry; }
    public void setEventHasFriday(Boolean eventHasFriday) { this.eventHasFriday = eventHasFriday; }
    public void setEventHasSaturday(Boolean eventHasSaturday) { this.eventHasSaturday = eventHasSaturday; }
    public void setEventVIPStatus(Boolean eventVIPStatus) { this.eventVIPStatus = eventVIPStatus; }
    public void setEventCostFullEntry(Double eventCostFullEntry) { this.eventCostFullEntry = eventCostFullEntry; }
    public void setEventCostFriday(Double eventCostFriday) { this.eventCostFriday = eventCostFriday; }
    public void setEventCostSaturday(Double eventCostSaturday) { this.eventCostSaturday = eventCostSaturday; }
    public void setEventCostSunday(Double eventCostSunday) { this.eventCostSunday = eventCostSunday; }
    public void setEventTShirtCost(Double eventTShirtCost) { this.eventTShirtCost = eventTShirtCost; }
    public void setEventMaskCost(Double eventMaskCost) { this.eventMaskCost = eventMaskCost; }
    public void setEventCostPriority(Double eventCostPriority) { this.eventCostPriority = eventCostPriority; }
    public void setEventVIPCost(Double eventVIPCost) { this.eventVIPCost = eventVIPCost; }

    // Other Functions - data processors and other outputs, if any



}
