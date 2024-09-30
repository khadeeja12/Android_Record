package com.example.callerapp1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    private static final int REQUEST_CALL=1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editTextPhone);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void call(View view)
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else
        {
            makeCall();
        }
    }

    private void makeCall()
    {
        String number=editText.getText().toString();
        Intent i= new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel: "+number));
        startActivity(i);
    }

    public void onRequestPermissionResult(int requestCode,String[] permissions,int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            makeCall();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Permission denied",Toast.LENGTH_SHORT).show();
        }

    }
}