package com.example.displaynameapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
    public void show(View V){
        EditText e1=findViewById(R.id.editTextText);
        EditText e2=findViewById(R.id.editTextText2);
        EditText e3=findViewById(R.id.editTextText3);
        TextView tv1=findViewById(R.id.textView4);
        TextView tv2=findViewById(R.id.textView5);
        double num1 = Double.parseDouble(e1.getText().toString());
        double num2 = Double.parseDouble(e2.getText().toString());
        double num3 = Double.parseDouble(e3.getText().toString());
        double sum = num1 + num2 + num3;
        double average = sum / 3;

        String formattedSum = String.format("%.2f", sum);
        String formattedAverage = String.format("%.2f", average);
        tv1.setText("Sum : "+formattedSum);
        tv2.setText("Average : "+ formattedAverage);
    }

}