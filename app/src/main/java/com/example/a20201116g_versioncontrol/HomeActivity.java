package com.example.a20201116g_versioncontrol;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a20201116g_versioncontrol.constants.JsonConstants;
import com.example.a20201116g_versioncontrol.model.registrationsInformation.RegistrationsInformationController;
import com.example.a20201116g_versioncontrol.model.version.VersionController;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Context applicationContext;
    private VersionController versionController;
    private RegistrationsInformationController registrationsInformationController;

    private TextView helloWorld;
    private TextView jsonOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationContext = getApplicationContext();

        setContentView(R.layout.home_activity);
        helloWorld = (TextView) findViewById(R.id.helloWorld);
        jsonOutput = (TextView) findViewById(R.id.jsonOutput);

        this.versionController = new VersionController(applicationContext);
        this.helloWorld.setText("Version: " + this.versionController.getRegistrationsVersion().toString());

        this.registrationsInformationController = new RegistrationsInformationController(applicationContext);
        this.jsonOutput.setText(registrationsInformationController.getRegistrationsJson());

        ArrayList<String> arrayList = registrationsInformationController.getListEventCodes();
        for (int i = 0; i < arrayList.size(); i++) {

            String eventName = registrationsInformationController.getInformationString(JsonConstants.EVENT_NAME_LONG, arrayList.get(i));
            Log.d("CodeList123: ",arrayList.get(i) + " - " + eventName);

        }

        String eventCodeChecker = "SLAGC21";

        String eventID = registrationsInformationController.getInformationString(JsonConstants.EVENT_ID, eventCodeChecker);
        Log.d("ID123: ", eventID);

        String eventUniqueCode = registrationsInformationController.getInformationString(JsonConstants.EVENT_UNIQUE_CODE, eventCodeChecker);
        Log.d("UniqueCode123: ", eventUniqueCode);

        String eventLocationCode = registrationsInformationController.getInformationString(JsonConstants.EVENT_LOCATION_CODE, eventCodeChecker);
        Log.d("LocationCode123: ", eventLocationCode);

        String eventWebsite = registrationsInformationController.getInformationString(JsonConstants.EVENT_WEBSITE, eventCodeChecker);
        Log.d("Website123: ", eventWebsite);

        String eventName = registrationsInformationController.getInformationString(JsonConstants.EVENT_NAME, eventCodeChecker);
        Log.d("Name123: ", eventName);

        String eventNameLong = registrationsInformationController.getInformationString(JsonConstants.EVENT_NAME_LONG, eventCodeChecker);
        Log.d("NameLong123: ", eventNameLong);

        String eventAddress = registrationsInformationController.getInformationString(JsonConstants.EVENT_ADDRESS, eventCodeChecker);
        Log.d("Address123: ", eventAddress);

        String eventPaymentDeadline = registrationsInformationController.getInformationString(JsonConstants.EVENT_PAYMENT_DEADLINE, eventCodeChecker);
        Log.d("PaymentDead123: ", eventPaymentDeadline);

        String eventDatesString = registrationsInformationController.getInformationString(JsonConstants.EVENT_DATES_STRING, eventCodeChecker);
        Log.d("DatesString123: ", eventDatesString);

        String eventDatesStart = registrationsInformationController.getInformationString(JsonConstants.EVENT_START_DATE, eventCodeChecker);
        Log.d("DateStart123: ", eventDatesStart);

        String eventDatesEnd = registrationsInformationController.getInformationString(JsonConstants.EVENT_END_DATE, eventCodeChecker);
        Log.d("DateEnd123: ", eventDatesEnd);

        String eventHasFullEntry = registrationsInformationController.getInformationBoolean(JsonConstants.EVENT_HAS_FULL_ENTRY, eventCodeChecker).toString();
        Log.d("HasFullEntry123: ", eventHasFullEntry);

        String eventHasFriday = registrationsInformationController.getInformationBoolean(JsonConstants.EVENT_HAS_FRIDAY, eventCodeChecker).toString();
        Log.d("HasFriday123: ", eventHasFriday);

        String eventHasSaturday = registrationsInformationController.getInformationBoolean(JsonConstants.EVENT_HAS_SATURDAY, eventCodeChecker).toString();
        Log.d("HasSaturday123: ", eventHasSaturday);

        String eventVIPStatus = registrationsInformationController.getInformationBoolean(JsonConstants.EVENT_VIP_STATUS, eventCodeChecker).toString();
        Log.d("VIPStatus123: ", eventVIPStatus);

        DecimalFormat df2 = new DecimalFormat("#.00");

        String eventCostFullEntry = df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_FULL_ENTRY, eventCodeChecker));
        Log.d("CostFull123: ", eventCostFullEntry);

        String eventCostFriday= df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_FRIDAY, eventCodeChecker));
        Log.d("CostFriday123: ", eventCostFriday);

        String eventCostSaturday = df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_SATURDAY, eventCodeChecker));
        Log.d("CostSaturday123: ", eventCostSaturday);

        String eventCostSunday = df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_SUNDAY, eventCodeChecker));
        Log.d("CostSunday123: ", eventCostSunday);

        String eventCostTShirt = df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_TSHIRT, eventCodeChecker));
        Log.d("CostTShirt123: ", eventCostTShirt);

        String eventCostMask = df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_MASK, eventCodeChecker));
        Log.d("CostMask123: ", eventCostMask);

        String eventCostPriority = df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_PRIORITY, eventCodeChecker));
        Log.d("CostPriority123: ", eventCostPriority);

        String eventCostVIP = df2.format(registrationsInformationController.getInformationDouble(JsonConstants.EVENT_COST_VIP, eventCodeChecker));
        Log.d("CostVIP123: ", eventCostVIP);

        Double testDouble = 3.50;
        Log.d("TestDouble123",df2.format(testDouble));

    }

    @Override
    public void onBackPressed() {
        exitApplication();
    }

    public void exitApplication() {
        finish();
    }


}
