package com.example.sumapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


    }
    public void calculate(View v){
        EditText e1 = findViewById(R.id.editTextText);
        EditText e2 = findViewById(R.id.editTextText2);
        int n1=Integer.parseInt(e1.getText().toString());
        int n2=Integer.parseInt(e2.getText().toString());
        Intent i=new Intent(MainActivity.this,SumActivity.class);
        i.putExtra("message","Sum is : ");
        i.putExtra("a",n1);
        i.putExtra("b",n2);
         startActivity(i);
    }
}