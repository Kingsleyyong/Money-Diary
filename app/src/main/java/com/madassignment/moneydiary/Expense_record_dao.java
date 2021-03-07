package com.madassignment.moneydiary;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Expense_record_dao extends SQLiteOpenHelper {


    private static final String expenseDB = "expense";
    private static final String expenseID = "expenseID";
    private static final String expenseDesc = "expenseDesc";
    private static final String expenseAmt = "expenseAmt";
    private static final String expenseCate = "expenseCate";
    private static final String expenseDate = "expenseDate";

    public Expense_record_dao(@Nullable Context context) {
        super(context, "moneydiary_expense.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + expenseDB +
                "("+ expenseID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                expenseDesc + " TEXT, "
                + expenseAmt +" REAL, "
                + expenseCate + " TEXT, "
                + expenseDate + " INTEGER" + ")";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(expense_record newExpense) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(expenseDesc, newExpense.getDecs());
        cv.put(expenseAmt, newExpense.getPrice());
        cv.put(expenseCate, newExpense.getCategory());
        cv.put(expenseDate, newExpense.getDate());

        long insert = db.insert(expenseDB, null, cv);

        if (insert == -1) {
            return false;
        }
        return true;
    }

    public boolean deleteOne(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        int delete = db.delete(expenseDB, " ExpenseID =" + id, null);

        if (delete == 0) {
            return false;
        }
        return true;
    }

    public List<expense_record> getAll() {
        List<expense_record> list = new ArrayList<expense_record>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.query(expenseDB, new String[]{expenseID, expenseDesc, expenseAmt, expenseCate, expenseDate}, null, null, null, null, null, null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
            expense_record q = new expense_record(result.getInt(0), result.getString(1), result.getDouble(2), result.getString(3), result.getString(4));
            list.add(q);
        }

        result.close();

        return list;
    }

    public List<expense_record> queryOne(String cate){
        List<expense_record> list = new ArrayList<expense_record>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.query(expenseDB, new String[]{expenseID, expenseDesc, expenseAmt, expenseCate, expenseDate}, " " + expenseCate + "=" + cate, null, null, null, null, null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
            expense_record q = new expense_record(result.getInt(0), result.getString(1), result.getDouble(2), result.getString(3), result.getString(4));
            list.add(q);
        }
        result.close();

        return list;
    }

    public double totalExpense(){
        SQLiteDatabase db = this.getReadableDatabase();
        double total = 0;
        Cursor result = db.query(expenseDB, new String[]{expenseID, expenseDesc, expenseAmt, expenseCate, expenseDate}, null, null, null, null, null, null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
            total += result.getDouble(2);
        }

        result.close();

        return total;
    }

    public int totalNumber(){
        SQLiteDatabase db = this.getReadableDatabase();
        int total = 0;
        Cursor result = db.query(expenseDB, new String[]{expenseID}, null, null, null, null, null, null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
            total += 1;
        }

        result.close();

        return total;
    }
}

