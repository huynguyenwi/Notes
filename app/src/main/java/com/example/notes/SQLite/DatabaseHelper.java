package com.example.notes.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.notes.NoteModel.Notes;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "notes.db";
    public static String TABLE_NAME = "Notes";

    public static String COLUMN_ID = "Id";
    public static String COLUMN_TITLE = "Title";
    public static String COLUMN_DESCRIPTION = "Description";
    public static String COLUMN_DATE = "Date";
    public static String COLUMN_TIME = "Time";
    public static String COLUMN_COLOR1 = "color1";
    public static String COLUMN_COLOR2 = "color2";



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_COLOR1 + " INTEGER, " +
                COLUMN_COLOR2 + " INTEGER " + ")";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i > i1)
            return;
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long AddNote(Notes notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, notes.getTitle());
        contentValues.put(COLUMN_DESCRIPTION, notes.getDescription());
        contentValues.put(COLUMN_DATE, notes.getDate());
        contentValues.put(COLUMN_TIME, notes.getTime());
        contentValues.put(COLUMN_COLOR1, notes.getColor1());
        contentValues.put(COLUMN_COLOR2, notes.getColor2());


        long ID = db.insert(TABLE_NAME, null, contentValues);
        return ID;
    }

    public List<Notes> getNote(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Notes> allNote = new ArrayList<>();

        String queryStatement = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                COLUMN_DATE + " ASC, " + COLUMN_TIME + " ASC";

        Cursor cursor = db.rawQuery(queryStatement, null);

        if (cursor != null && cursor.moveToFirst()){
            do {
                Notes notes = new Notes();
                notes.setId(cursor.getInt(0));
                notes.setTitle(cursor.getString(1));
                notes.setDescription(cursor.getString(2));
                notes.setDate(cursor.getString(3));
                notes.setColor1(cursor.getInt(4));
                notes.setColor2(cursor.getInt(5));


                allNote.add(notes);
            }while (cursor.moveToNext());
        }
        return allNote;
    }


    public Notes getNotes(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] query = new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_DESCRIPTION, COLUMN_DATE, COLUMN_TIME, COLUMN_COLOR1, COLUMN_COLOR2};
        Cursor cursor = db.query(TABLE_NAME, query, COLUMN_ID + " =?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            return new Notes(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6));


        } else {
            return null;
        }
    }



    public void deleteNote(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " =?", new String[]{String.valueOf(id)});
        db.close();
    }


    public void updateNote(int id, String title, String description, String date, String time, int color1, int color2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_TITLE,title);
        contentValues.put(COLUMN_DESCRIPTION,description);
        contentValues.put(COLUMN_DATE,date);
        contentValues.put(COLUMN_TIME,time);
        contentValues.put(COLUMN_COLOR1,color1);
        contentValues.put(COLUMN_COLOR2,color2);



        db.update(TABLE_NAME,contentValues,COLUMN_ID+"=?", new String[]{String.valueOf(id)});

    }


    public void deleteAll(){
            SQLiteDatabase db = this.getReadableDatabase();
            db.delete(TABLE_NAME,null,null);
    }


}
