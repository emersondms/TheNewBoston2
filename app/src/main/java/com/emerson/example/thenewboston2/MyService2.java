package com.emerson.example.thenewboston2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService2 extends Service {

    private final IBinder buckysBinder = new MyLocalBinder();

    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return buckysBinder;
    }

    public String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (df.format(new Date()));
    }

    public class MyLocalBinder extends Binder {
        MyService2 getService() {
            return MyService2.this;
        }
    }

}
