package com.example.optionsmenuapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       Toolbar tool=findViewById(R.id.toolbar);
        setSupportActionBar(tool);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menu1,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.i1){
            Toast.makeText(MainActivity.this, "item 1 is selected", Toast.LENGTH_LONG).show();
        }
        if(id==R.id.i2){
            Toast.makeText(MainActivity.this, "item 2 is selected", Toast.LENGTH_LONG).show();
        }
        if(id==R.id.i21){
            Toast.makeText(MainActivity.this, "item 1 in Item 2 is selected", Toast.LENGTH_LONG).show();
        }
        if(id==R.id.i22){
            Toast.makeText(MainActivity.this, "item 2 in Item 2 is selected", Toast.LENGTH_LONG).show();
        }
        if(id==R.id.i3){
            Toast.makeText(MainActivity.this, "item 3 is selected", Toast.LENGTH_LONG).show();
        }
        if(id==R.id.i4){
            Toast.makeText(MainActivity.this, "item 4 is selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}