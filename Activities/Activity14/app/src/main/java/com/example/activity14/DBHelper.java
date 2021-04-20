package com.example.activity14;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;

    public static final String DATABASE_NAME = "Friends.db";
    public static final String TABLE_NAME = "friends_table";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_HOBIE = "HOBIE";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME + " ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT,"+COL_HOBIE+" TEXT)");
    }

    public static synchronized DBHelper getInstance(Context context){
        if(instance == null){
            instance = new DBHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String hobie){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_HOBIE, hobie);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateData(String name, String hobie){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_HOBIE, hobie);
        String[] args = {name};
        long result = db.update(TABLE_NAME, contentValues, COL_NAME + "= ?", args);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = {name};
        long result = db.delete(TABLE_NAME, COL_NAME + "= ?", args);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateDataHobbie(String hobie){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_HOBIE, hobie);
        contentValues.put(COL_NAME, "Ceci");
        long result = db.update(COL_HOBIE, contentValues,  "ID = "+"1", null);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
}
