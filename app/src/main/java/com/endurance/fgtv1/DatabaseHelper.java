package com.endurance.fgtv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jipsa on 3/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "userName";
    private static final String COLUMN_PASSWORD = "password";
    //private static final String COLUMN_HEIGHT = "height";
    //private static final String COLUMN_WEIGHT = "weight";
    //private static final String COLUMN_AGE = "age";
    SQLiteDatabase db;

    private static final String TABLE_CREATE= "create table contacts(id primary key not null, "+
            "userName text not null, "+ "password text not null);";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db=db;
    }


    public void insertContact(Contact c){
        db = this.getWritableDatabase(); //to insert into db, it should be writable
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null); //used to find the count of contacts that are present
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_USERNAME,c.getUserName());
        values.put(COLUMN_PASSWORD,c.getPassword());
        /*values.put(COLUMN_HEIGHT,c.getHeight());
        values.put(COLUMN_WEIGHT,c.getWeight());
        values.put(COLUMN_AGE,c.getAge());*/

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPass(String uName){

        db = this.getReadableDatabase();
        String query = "select userName, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b = "Not Found";
        if(cursor.moveToFirst())
        {

            do{
                a = cursor.getString(0);
                if(a.equals(uName)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());

        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS"+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
