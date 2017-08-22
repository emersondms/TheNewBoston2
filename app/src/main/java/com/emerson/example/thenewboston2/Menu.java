package com.emerson.example.thenewboston2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

    Class ourClass;
    String classes[] = {
        "JavaInterface", "GridLayout", "Gestures",
        "Fragments", "OverflowMenu", "Transitions",
        "Apples", "SendBroadcast", "Threads",
        "BoundServices", "ListViewExample", "SQLite",
        "VideoPlayer", "ImageCapture", "ImageEffects",
        "Notifications", "SharedPrefs"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(
            Menu.this, android.R.layout.simple_list_item_1, classes
        ));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            ourClass = Class.forName(
                "com.emerson.example.thenewboston2." + cheese
            );
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
