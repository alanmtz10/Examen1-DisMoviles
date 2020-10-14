package com.example.e1_alanmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        video = findViewById(R.id.videoView);

        video.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=oIhCyPaDP6g"));
        video.start();
    }
}