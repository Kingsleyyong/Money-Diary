/*
package com.madassignment.moneydiary;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {expense_record.class}, version = 1)

public abstract class ExpenseRoomDatabase  extends RoomDatabase{
    private static final String dbname= "Expense_database";
    public abstract Expense_record_dao expenseRecordDao();

    private static ExpenseRoomDatabase INSTANCE;
    static ExpenseRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null) {
            synchronized (ExpenseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    ExpenseRoomDatabase.class,
                                    "Expense_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
*/
