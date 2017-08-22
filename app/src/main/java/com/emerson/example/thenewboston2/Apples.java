package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Apples extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apples);

        Intent i = new Intent(this, MyService.class);
        startService(i);
    }

    public void onClick(View view) {
        Intent i = new Intent(this, Bacon.class);
        final EditText applesInput = (EditText) findViewById(R.id.applesInput);
        String userMessage = applesInput.getText().toString();
        i.putExtra("applesMessage", userMessage);
        startActivity(i);
    }

}
