package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class JavaInterface extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Layout
        RelativeLayout buckysLayout = new RelativeLayout(this);
        buckysLayout.setBackgroundColor(Color.GREEN);

        //Button
        Button redButton = new Button(this);
        redButton.setText("Log in");
        redButton.setBackgroundColor(Color.RED);
        redButton.setId(1);

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //Username input
        EditText userName = new EditText(this);
        userName.setId(2);

        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Give rules to position widgets
        userNameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0, 0, 0, 50);

        //Converting DIP to Pixels
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            200, r.getDisplayMetrics()
        );

        userName.setWidth(px);

        //Add widget to layout(button is now a child of layout)
        buckysLayout.addView(redButton, buttonDetails);
        buckysLayout.addView(userName, userNameDetails);

        //Set this activities content/display to this view
        setContentView(buckysLayout);
    }

}
