package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPrefs extends Activity {

    EditText usernameInput, passwordInput;
    TextView buckysText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        buckysText = (TextView) findViewById(R.id.buckysPrefsText);
    }

    //Save the users login info
    public void saveInfo(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences(
            "userInfo", Context.MODE_PRIVATE
        );

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

    //Print out the saved data
    public void displayData(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences(
            "userInfo", Context.MODE_PRIVATE
        );

        String name = sharedPrefs.getString("username", "");
        String pswd = sharedPrefs.getString("password", "");
        buckysText.setText(name + " " + pswd);
    }

}
