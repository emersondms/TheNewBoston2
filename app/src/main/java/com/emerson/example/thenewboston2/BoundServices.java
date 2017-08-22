package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class BoundServices extends Activity {

    MyService2 buckysService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_services);

        Intent i = new Intent(this, MyService2.class);
        bindService(i, buckysConnection, Context.BIND_AUTO_CREATE);
    }

    public void showTime(View v) {
        String currentTime = buckysService.getCurrentTime();
        TextView buckysText = (TextView) findViewById(R.id.buckysText2);
        buckysText.setText(currentTime);
    }

    private ServiceConnection buckysConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService2.MyLocalBinder binder = (MyService2.MyLocalBinder) service;
            buckysService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

}
