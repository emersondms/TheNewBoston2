package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

public class ImageEffects extends Activity {

    ImageView buckysImageView;
    Drawable sky;
    Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_effects);

        buckysImageView = (ImageView) findViewById(R.id.buckysImageView);
        /*sky = getResources().getDrawable(R.drawable.sky);
        bitmapImage = ((BitmapDrawable) sky).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImage);
        buckysImageView.setImageBitmap(newPhoto);*/

        Drawable[] layers = new Drawable[2];
        layers[0] = getResources().getDrawable(R.drawable.sky);
        layers[1] = getResources().getDrawable(R.drawable.birds);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        buckysImageView.setImageDrawable(layerDrawable);

        //Save the image to the users device
        /*MediaStore.Images.Media.insertImage(
            getContentResolver(), newPhoto, "Title", "Description"
        );*/
    }

    //Invert a bitmap image
    /*private Bitmap invertImage(Bitmap original) {
        Bitmap finalImage = Bitmap.createBitmap(
            original.getWidth(), original.getHeight(), original.getConfig()
        );

        int A, R, G, B, pixelColor,
        height = original.getHeight(),
        width = original.getWidth();

        for (int y=0; y < height; y++) {
            for (int x=0; x < width; x++) {
                pixelColor = original.getPixel(x, y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        return finalImage;
    }*/

}
