package com.example.crudapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2, edit3;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.text_name);
        edit2 = findViewById(R.id.text_course);
        edit3 = findViewById(R.id.text_sem);
        // dbHandler = new dbHandler(MainActivity.this);
        dbHandler =new DBHandler(MainActivity.this);
    }
    public void newStudent(View v)
    {
        //get values from edit text
        String studentName=edit1.getText().toString();
        String studentCourse=edit2.getText().toString();
        int studentSemester=Integer.parseInt(edit3.getText().toString());
        dbHandler.addNewStudent(studentName,studentCourse,studentSemester);
        Toast.makeText(MainActivity.this,"Student is added",Toast.LENGTH_LONG).show();
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
    }
    public void findStudent(View v){
        String studentName = edit1.getText().toString().trim();
        Student student=dbHandler.searchStudent(studentName);
        if (student!=null){
            edit2.setText(String.valueOf(student.getCourse()));
            edit3.setText(String.valueOf(student.getSemester()));
        }
        else {
            Toast.makeText(this, "No Match Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteStudent(View v){
        String studentName=edit1.getText().toString();
        boolean result=dbHandler.deleteStudent_DBH(studentName);
        if (result){
            Toast.makeText(this, "record deleted", Toast.LENGTH_SHORT).show();
            edit1.setText("");
            edit2.setText("");
            edit3.setText("");
        }
        else {
            Toast.makeText(this, "No Match Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateStudent(View v) {
        String studentName = edit1.getText().toString().trim();
        String studentCourse = edit2.getText().toString().trim();
        int studentSemester = Integer.parseInt(edit3.getText().toString().trim());

        boolean updateSuccess = dbHandler.updateStudent(studentName, studentCourse, studentSemester);

        if (updateSuccess) {
            Toast.makeText(MainActivity.this, "Student is updated", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Student not found", Toast.LENGTH_SHORT).show();
        }
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
    }

}