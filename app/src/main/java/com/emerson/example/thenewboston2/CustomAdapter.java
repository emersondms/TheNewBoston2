package com.emerson.example.thenewboston2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());

        View customView = buckysInflater.inflate(
            R.layout.custom_row, parent, false
        );

        String singleFoodItem = getItem(position);

        TextView buckysText = (TextView) customView.findViewById(
            R.id.buckysTextListView
        );
        buckysText.setText(singleFoodItem);

        ImageView buckysImage = (ImageView) customView.findViewById(
            R.id.buckysImage
        );
        buckysImage.setImageResource(R.drawable.ic_launcher);

        return customView;
    }

}
