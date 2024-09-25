package com.example.sumapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sum);
       Bundle e=getIntent().getExtras();
       if(e!=null)
       {
           TextView tv=findViewById(R.id.textView);
           String msg=e.getString("message");
           int num1=e.getInt("a");
           int num2=e.getInt("b");
           int s=num1+num2;
           tv.setText(msg+s);
       }
    }
}