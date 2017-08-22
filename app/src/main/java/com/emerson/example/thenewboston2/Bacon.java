package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Bacon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bacon);

        Bundle applesData = getIntent().getExtras();
        if (applesData == null) {
            return;
        }

        String applesMessage = applesData.getString("applesMessage");
        TextView baconText = (TextView) findViewById(R.id.baconText);
        baconText.setText(applesMessage);
    }

}
