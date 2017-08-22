package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class Notifications extends Activity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void buckysButtomClicked(View view) {
        //Build the notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the ticker!");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title!");
        notification.setContentText("I am the body text of your notification!");

        Intent intent = new Intent(this, Notifications.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        notification.setContentIntent(pendingIntent);

        //Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(
            NOTIFICATION_SERVICE
        );
        nm.notify(uniqueID, notification.build());
    }

}
