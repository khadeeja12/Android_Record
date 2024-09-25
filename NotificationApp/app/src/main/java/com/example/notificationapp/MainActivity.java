package com.example.notificationapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import android.content.Context;
import android.os.Build;



public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID ="example_channel";
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            createAChannel();
    }
    public void createAChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O);
        {
            CharSequence name="Example Channel";
            //importance level of the channel
            int importance=NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,name,importance);
            //Register channel with the android system
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void notify(View view)
    {
        //Build and display notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.msg)
                .setContentTitle("NOTIFICATION")
                .setContentText("This is a notification")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager man=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        man.notify(1,builder.build());

    }
}