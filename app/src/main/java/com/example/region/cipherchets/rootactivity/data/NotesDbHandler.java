package com.example.region.cipherchets.rootactivity.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.region.cipherchets.rootactivity.model.Notes;
import com.example.region.cipherchets.rootactivity.params.Params;

import java.util.ArrayList;
import java.util.List;

public class NotesDbHandler extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;
    public static final String DB_NAME="notes_db";
    public NotesDbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.DB_TABLE + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY, " + Params.KEY_DATE
                + " TEXT, " + Params.KEY_TIME + " TEXT, " + Params.KEY_SHORTDESC
                + " TEXT, "+Params.KEY_LONGDESC + " TEXT" + ")";
        Log.d("debug","onCreate : "+create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNotes(Notes notes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Params.KEY_DATE,notes.getDate());
        contentValues.put(Params.KEY_TIME,notes.getTime());
        contentValues.put(Params.KEY_SHORTDESC,notes.getShort_desc());
        contentValues.put(Params.KEY_LONGDESC,notes.getLong_desc());

        db.insert(Params.DB_TABLE,null,contentValues);
        Log.d("debug","Successfully inserted");
        db.close();
    }
    public List<Notes> getAllNotes(){
        List<Notes> notesList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ Params.DB_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Notes notes = new Notes();
                notes.setId(Integer.parseInt(cursor.getString(0)));
                notes.setDate(cursor.getString(1));
                notes.setTime(cursor.getString(2));
                notes.setShort_desc(cursor.getString(3));
                notes.setLong_desc(cursor.getString(4));
                notesList.add(notes);
            }while (cursor.moveToNext());
        }
        Log.d("debug","fetching");
        return notesList;
    }
    public int updateNotes(Notes notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_DATE,notes.getDate());
        values.put(Params.KEY_TIME,notes.getTime());
        values.put(Params.KEY_SHORTDESC,notes.getShort_desc());
        values.put(Params.KEY_LONGDESC,notes.getLong_desc());
        return db.update(Params.DB_TABLE,values,Params.KEY_ID+"=?",
                        new String[]{String.valueOf(notes.getId())});
    }
    public void deleteNotes(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.DB_TABLE,Params.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }
}
