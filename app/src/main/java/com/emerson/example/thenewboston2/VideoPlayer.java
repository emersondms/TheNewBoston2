package com.emerson.example.thenewboston2;

import android.app.Activity;
import android.widget.MediaController;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoPlayer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        final VideoView buckysVideoView = (VideoView) findViewById(
            R.id.buckysVideoView
        );
        buckysVideoView.setVideoPath(
            "http://www.webestools.com/page/media/videoTag/BigBuckBunny.mp4"
        );

        //Player controls (play, pause, stop, etc...)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(buckysVideoView);

        buckysVideoView.setMediaController(mediaController);
        buckysVideoView.start();
    }

}
