package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        String[] foods = {
            "Bacon", "Ham", "Tuna", "Candy", "Meatball", "Potato"
        };

        ListAdapter buckysAdapter = new CustomAdapter(this, foods);

        ListView buckysListView = (ListView) findViewById(R.id.buckysListView);
        buckysListView.setAdapter(buckysAdapter);
        buckysListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food = String.valueOf(
                    parent.getItemAtPosition(position)
                );

                Toast.makeText(
                    ListViewExample.this, food, Toast.LENGTH_LONG
                ).show();
            }
        });
    }

}
