package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SendBroadcast extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_broadcast);
    }

    public void sendOutBroadcast(View view) {
        Intent i = new Intent();
        i.setAction("com.emerson.example.thenewboston2");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);
    }

}