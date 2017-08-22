package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class Threads extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threads);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView buckysText = (TextView) findViewById(R.id.buckysText);
            buckysText.setText("Nice job Hoss!");
        }
    };

    public void clickBuckysButton(View view) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while (System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        } catch (Exception e) {}
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };

        Thread buckysThread = new Thread(r);
        buckysThread.start();
    }

}
