package com.burhan.mediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    private VideoView myPlayer;

    private Button returnButton;

    private MediaController myVideoController;

    private Uri videoLocation;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video);



        myPlayer = (VideoView) findViewById(R.id.videoView);

        returnButton = (Button) findViewById(R.id.homeButton);



        videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mp4);

        myVideoController = new MediaController(this);

        //prepare the video

        setupMedia();

        setupListeners();

    }



    private void setupListeners() {

        returnButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View currentView) {

                Intent returnIntent = new Intent();

                setResult(RESULT_OK, returnIntent);

                finish();

            }

        });

    }



    private void setupMedia() {

        myPlayer.setMediaController(myVideoController);

        myPlayer.setVideoURI(videoLocation);

    }

}
