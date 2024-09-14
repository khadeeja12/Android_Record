package com.example.audiovideoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.VideoView;
import android.widget.MediaController;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
    public void playmusic(View v){
        MediaPlayer r=MediaPlayer.create(MainActivity.this,R.raw.inspiration);
        r.start();
    }
    public void playvideo(View view){
        VideoView v=findViewById(R.id.videoView);
        v.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.swing);
        MediaController med=new MediaController(MainActivity.this);
        med.setAnchorView(v);
        med.setMediaPlayer(v);
        v.setMediaController(med);
        v.start();
    }
}