package com.madassignment.moneydiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class incomeDAO extends SQLiteOpenHelper {


    private static final String incomeDB = "income";
    private static final String incomeID = "incomeID";
    private static final String incomeDesc = "incomeDesc";
    private static final String incomeAmt = "incomeAmt";
    private static final String incomeCate = "incomeCate";
    private static final String incomeDate = "incomeDate";

    public incomeDAO(@Nullable Context context) {
        super(context, "moneydiary.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + incomeDB +"("+ incomeID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ incomeDesc + " TEXT, " + incomeAmt +" DOUBLE, " + incomeCate + " TEXT, " + incomeDate + " TEXT" + ")";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(income newincome) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(incomeDesc, newincome.getincomeDesc());
        cv.put(incomeAmt, newincome.getincomeAmt());
        cv.put(incomeCate, newincome.getincomeCate());
        cv.put(incomeDate, newincome.getincomeDate());

        long insert = db.insert(incomeDB, null, cv);

        if (insert == -1) {
            return false;
        }
        return true;
    }

    public boolean deleteOne(income oldincome) {
        SQLiteDatabase db = this.getWritableDatabase();

        int delete = db.delete(incomeDB, ("ID=" + oldincome.getincomeID()), null);

        if (delete == 0) {
            return false;
        }
        return true;
    }

    public List<income> getAll() {
        List<income> list = new ArrayList<income>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.query(incomeDB, new String[]{incomeID, incomeDesc, incomeAmt, incomeCate, incomeDate}, null, null, null, null, null, null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
            income q = new income(result.getInt(0), result.getString(1), result.getDouble(2), result.getString(3), result.getLong(4));
            list.add(q);
        }

        result.close();

        return list;
    }

    public List<income> queryOne(String cate){
        List<income> list = new ArrayList<income>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.query(incomeDB, new String[]{incomeID, incomeDesc, incomeAmt, incomeCate, incomeDate}, " " + incomeCate + "=" + cate, null, null, null, null, null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
            income q = new income(result.getInt(0), result.getString(1), result.getDouble(2), result.getString(3), result.getLong(4));
            list.add(q);
        }
        result.close();

        return list;
    }
}
