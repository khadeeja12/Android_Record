package com.example.videointernetapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.net.Uri;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void playVideo(View view){
        VideoView v=findViewById(R.id.videoView);
        String url="https://live-par-2-abr.livepush.io/vod/bigbuckbunnyclip.mp4";
        Uri uri=Uri.parse(url);
        v.setVideoPath(url);

        MediaController med=new MediaController(MainActivity.this);
        med.setAnchorView(v);
        med.setMediaPlayer(v);
        v.setMediaController(med);
        v.start();

    }
}