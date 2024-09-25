package com.example.conextmenuapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int COLOR_RED = 1;
    private static final int COLOR_GREEN = 2;
    private static final int COLOR_BLUE = 3;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        mainLayout = findViewById(R.id.main); // Assuming R.id.main is the root layout in activity_main.xml
        View textView = findViewById(R.id.textView);

        // Register the TextView for the context menu
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, COLOR_RED, 0, "Red");
        menu.add(0, COLOR_GREEN, 0, "Green");
        menu.add(0, COLOR_BLUE, 0, "Blue");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case COLOR_RED:
                mainLayout.setBackgroundColor(Color.RED);
                return true;
            case COLOR_GREEN:
                mainLayout.setBackgroundColor(Color.GREEN);
                return true;
            case COLOR_BLUE:
                mainLayout.setBackgroundColor(Color.BLUE);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
