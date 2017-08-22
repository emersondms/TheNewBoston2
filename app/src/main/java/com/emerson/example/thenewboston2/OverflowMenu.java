package com.emerson.example.thenewboston2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.RelativeLayout;

public class OverflowMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overflow_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout mainView = (RelativeLayout) findViewById(R.id.mainView);
        switch (item.getItemId()) {
            case R.id.menu_red: {
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                mainView.setBackgroundColor(Color.RED);
                return true;
            }
            case R.id.menu_green: {
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                mainView.setBackgroundColor(Color.GREEN);
                return true;
            }
            case R.id.menu_yellow: {
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                mainView.setBackgroundColor(Color.YELLOW);
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

}
