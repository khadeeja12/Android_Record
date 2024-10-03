package com.example.studentapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText edit1, edit2, edit3;
    public DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit1 = findViewById(R.id.et1);
        edit2 = findViewById(R.id.et2);
        edit3 = findViewById(R.id.et3);

        dbHandler = new DBHandler(MainActivity.this);
    }

    public void newStudent(View v) {
        String studentName = edit1.getText().toString();
        String studentCourse = edit2.getText().toString();
        String studentSemester = edit3.getText().toString();

        if (studentName.isEmpty() || studentCourse.isEmpty() || studentSemester.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter all the data.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Insert data to the database through ContentProvider
        ContentValues values = new ContentValues();
        values.put("name", studentName);
        values.put("course", studentCourse);
        values.put("semester", Integer.parseInt(studentSemester));

        // Insert through ContentProvider
        Uri uri = getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
        if (uri != null) {
            Toast.makeText(MainActivity.this, "Student added successfully", Toast.LENGTH_LONG).show();
            edit1.setText("");
            edit2.setText("");
            edit3.setText("");
        } else {
            Toast.makeText(MainActivity.this, "Failed to add student", Toast.LENGTH_SHORT).show();
        }
    }

    public void lookupStudent(View v) {
        TextView resultView = findViewById(R.id.display_tv);
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.example.studentapp.provider/student_details"),
                null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            StringBuilder studentData = new StringBuilder();
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String course = cursor.getString(2);
                int semester = cursor.getInt(3);

                studentData.append("ID: ").append(id)
                        .append(", Name: ").append(name)
                        .append(", Course: ").append(course)
                        .append(", Semester: ").append(semester).append("\n");
            } while (cursor.moveToNext());

            resultView.setText(studentData.toString());
        } else {
            resultView.setText("No Records Found");
        }
        if (cursor != null) {
            cursor.close();
        }
    }
}
