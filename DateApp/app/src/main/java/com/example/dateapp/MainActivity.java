package com.example.dateapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView tv1= findViewById(R.id.tv1);
        TextView tv2= findViewById(R.id.tv2);
        TextView tv3= findViewById(R.id.tv3);
        TextView tv4=findViewById(R.id.tv4);
        TextView tv5=findViewById(R.id.tv5);
        TextView tv6=findViewById(R.id.tv6);
        TextView tv7=findViewById(R.id.tv7);
        TextView tv8=findViewById(R.id.tv8);
        long dtlong=System.currentTimeMillis();
        tv1.setText("Long Format : "+Long.toString(dtlong));
        String dateTime;
        Calendar calendar;
        SimpleDateFormat  simpleDateFormat;

        calendar= Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss aaa z");
        dateTime=simpleDateFormat.format(calendar.getTime()).toString();
        tv2.setText(dateTime);

        calendar= Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aaa z");
        dateTime=simpleDateFormat.format(calendar.getTime()).toString();
        tv3.setText(dateTime);

        calendar= Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss aaa z");
        dateTime=simpleDateFormat.format(calendar.getTime()).toString();
        tv4.setText(dateTime);

        calendar= Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd.LLL.yyyy HH:mm:ss aaa z");
        dateTime=simpleDateFormat.format(calendar.getTime()).toString();
        tv5.setText(dateTime);

        calendar= Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd.LLLL.yyyy HH:mm:ss aaa z");
        dateTime=simpleDateFormat.format(calendar.getTime()).toString();
        tv6.setText(dateTime);

        calendar= Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("E.LLLL.yyyy HH:mm:ss aaa z");
        dateTime=simpleDateFormat.format(calendar.getTime()).toString();
        tv7.setText(dateTime);

        calendar= Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("EEEE.LLLL.yyyy KK:mm:ss aaa z");
        dateTime=simpleDateFormat.format(calendar.getTime()).toString();
        tv8.setText(dateTime);


    }
}