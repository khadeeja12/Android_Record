package com.example.studentapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentUris;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyContentProvider extends ContentProvider {
    static final String AUTHORITY = "com.example.studentapp.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + DBHandler.TABLE_NAME);

    private static final int STUDENTS = 1;
    private static final int STUDENT_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, DBHandler.TABLE_NAME, STUDENTS);
        uriMatcher.addURI(AUTHORITY, DBHandler.TABLE_NAME + "/#", STUDENT_ID);
    }

    private DBHandler dbHandler;

    @Override
    public boolean onCreate() {
        dbHandler = new DBHandler(getContext());
        return dbHandler != null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        long id = db.insert(DBHandler.TABLE_NAME, null, values);
        Uri newUri = ContentUris.withAppendedId(CONTENT_URI, id);
        getContext().getContentResolver().notifyChange(newUri, null);
        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        Cursor cursor;
        int match = uriMatcher.match(uri);

        switch (match) {
            case STUDENTS:
                cursor = db.query(DBHandler.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case STUDENT_ID:
                selection = DBHandler.ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(DBHandler.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }


    @Override
    public String getType(Uri uri) {
        int match = uriMatcher.match(uri);
        switch (match) {
            case STUDENTS:
                return "vnd.android.cursor.dir/" + AUTHORITY + "." + DBHandler.TABLE_NAME;
            case STUDENT_ID:
                return "vnd.android.cursor.item/" + AUTHORITY + "." + DBHandler.TABLE_NAME;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }
}
