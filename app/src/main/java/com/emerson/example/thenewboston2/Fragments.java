package com.emerson.example.thenewboston2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Fragments extends FragmentActivity
    implements TopSectionFragment.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments);
    }

    //This gets called by the Top Fragment when the user clicks the button
    @Override
    public void createMeme(String top, String bottom) {
        BottomPictureFragment bottomFragment =
        (BottomPictureFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragment2
        );
        bottomFragment.setMemeText(top, bottom);
    }

}
