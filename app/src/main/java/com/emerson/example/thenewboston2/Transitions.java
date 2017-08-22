package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Transitions extends Activity {

    ViewGroup buckysLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitions);

        buckysLayout = (ViewGroup) findViewById(R.id.buckysLayout);
        buckysLayout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveButton();
                return true;
            }
        });
    }

    public void moveButton() {
        View buckysButton = findViewById(R.id.buckysButton);

        TransitionManager.beginDelayedTransition(buckysLayout);

        //Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        buckysButton.setLayoutParams(positionRules);

        //Change the size of the button
        ViewGroup.LayoutParams sizeRules = buckysButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;

        buckysButton.setLayoutParams(sizeRules);
    }

}
