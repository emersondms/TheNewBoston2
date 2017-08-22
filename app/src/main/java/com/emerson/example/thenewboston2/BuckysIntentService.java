package com.emerson.example.thenewboston2;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class BuckysIntentService extends IntentService {

    private static final String TAG = "com.emerson.example.thenewboston2";

    public BuckysIntentService() {
        super("BuckysIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
        Log.i(TAG, "The Service has now started!");
    }

}
