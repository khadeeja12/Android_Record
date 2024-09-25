package com.example.custbrodcast;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;

import android.content.IntentFilter;

public class MainActivity extends AppCompatActivity {
    MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        configureReceiver();
    }
    public void brodcast(View view){
        Intent intent = new Intent();
        intent.setAction("com.example.custbrodcast");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    private void configureReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.custbrodcast");
        myReceiver=new MyReceiver();
        registerReceiver(myReceiver,intentFilter);
    }

    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}