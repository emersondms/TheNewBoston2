package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageCapture extends Activity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView buckysImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_capture);

        Button buckysButton = (Button) findViewById(R.id.buckysImageCaptureButton);
        buckysImageView = (ImageView) findViewById(R.id.buckysImageView);

        //Disable the button if the user has no camera
        if (!hasCamera()) {
            buckysButton.setEnabled(false);
        }
    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(
            PackageManager.FEATURE_CAMERA_ANY
        );
    }

    //Launching the camera
    public void launchCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and pass results along to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    //If you want to return the image taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            buckysImageView.setImageBitmap(photo);
        }
    }

}
