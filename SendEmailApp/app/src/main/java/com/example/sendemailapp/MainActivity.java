package com.example.sendemailapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

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
    }

    public void sendEmail(View view)
    {
        Log.i("key1: ","Start Email");
        String[] TO={};
        String[] CC={};
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("MailTo: "));
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL,TO);
        i.putExtra(Intent.EXTRA_EMAIL,CC);
        i.putExtra(Intent.EXTRA_SUBJECT,"Your Subject");
        i.putExtra(Intent.EXTRA_TEXT,"Content");
        try {
            startActivity(Intent.createChooser(i,"Select an App"));
            finish();
            Log.i("Finished sending Email","");
        }
        catch (android.content.ActivityNotFoundException e)
        {
            Toast.makeText(MainActivity.this,"There is no mail client installed",Toast.LENGTH_SHORT).show();
        }
    }
}