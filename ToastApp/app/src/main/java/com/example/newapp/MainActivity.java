package com.example.newapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView tv= findViewById(R.id.tv1);
        tv.setText("Welcome To ToastApp");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})

       long dtlong=System.currentTimeMillis();

        Toast.makeText(MainActivity.this,"Activity launched successfully",Toast.LENGTH_LONG).show();
    }
}