package com.madassignment.moneydiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDatabase extends SQLiteOpenHelper {

    private static final String TAG = "UserDatabase";

    private static final String User_Table = "User_Table";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "uemail";
    private static final String COL4 = "pass";
    private static final String COL5 = "confirmPass";

    public UserDatabase (Context context) {
        super(context, User_Table, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + User_Table +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + "TEXT) ";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP If TABLE EXISTS " + User_Table);
        onCreate(db);
    }

    public boolean addData (String name, String mail, String pw, String cfpw) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, mail);
        contentValues.put(COL4, pw);
        contentValues.put(COL5, cfpw);

        Log.d(TAG, "addData : Adding " + name + " to " + User_Table);

        long result = db.insert(User_Table, null, contentValues);

        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
