package com.example.launchwebpageapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
    public void loadWeb(View v){
        EditText edit=findViewById(R.id.et);
        String var=edit.getText().toString();
        Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(var));
        startActivity(i);

    }
}