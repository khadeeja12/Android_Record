package com.example.crudapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;

public class DBHandler extends SQLiteOpenHelper{
    //create constant values
    //dbname
    private static final String DB_NAME="student_db";
    //db version
    private static final int DB_VERSION=1;
    //table name
    private static final String TABLE_Name="student_details";
    //columns
    private static final String ID="id";
    private static final String NAME="name";
    private static final String COURSE="course";
    private static final String SEMESTER="semester";
    //constructor
    public DBHandler(Context context)
    {
        //arguments:context object,db name,
        //null,db version
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query= "CREATE TABLE "+TABLE_Name+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" TEXT,"+COURSE+" TEXT,"+SEMESTER+" INTEGER)";
        //execute above query
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //check if the table already exists
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_Name);
        onCreate(sqLiteDatabase);
    }
    //function for inserting
    public void addNewStudent(String name, String course, int semester)
    {
        //open db for writing
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //pass data as key-value pairs
        values.put(NAME,name);
        values.put(COURSE,course);
        values.put(SEMESTER,semester);
        //pass content values to the table
        db.insert(TABLE_Name,null,values);
        // db.close();
    }

    public Student searchStudent(String studentName){

        SQLiteDatabase db1=this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("SELECT * FROM " + TABLE_Name + " WHERE " + NAME + " = ? COLLATE NOCASE", new String[]{studentName});
        Student student=new Student();

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            student.setId(Integer.parseInt(cursor.getString(0)));
            student.setName(cursor.getString(1));
            student.setCourse(cursor.getString(2));
            student.setSemester(Integer.parseInt(cursor.getString(3)));
            cursor.close();
        }
        else {
            student=null;
        }
        return  student;
    }


    public boolean deleteStudent_DBH(String studentName){
        boolean result=false;
        SQLiteDatabase db1=this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("SELECT * FROM "+TABLE_Name+" WHERE "+NAME+" = ?",new String[]{studentName});
        Student student=new Student();

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            student.setId(Integer.parseInt(cursor.getString(0)));
            db1.delete(TABLE_Name,"ID=?",new String[]{String.valueOf(student.getId())});
            cursor.close();
            result = true;
        }
        return result;
    }
    public boolean updateStudent(String studentName, String course, int semester) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, studentName);
        values.put(COURSE, course);
        values.put(SEMESTER, semester);
        int rowsAffected = db1.update(TABLE_Name, values, NAME + " = ? COLLATE NOCASE", new String[]{studentName});
        db1.close();
        return rowsAffected > 0;
    }

}
