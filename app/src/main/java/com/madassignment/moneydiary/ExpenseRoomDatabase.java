package com.madassignment.moneydiary;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {expense_record.class}, version = 1)

public abstract class ExpenseRoomDatabase extends RoomDatabase{
    private static ExpenseRoomDatabase INSTANCE;
    static ExpenseRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null) {
            synchronized (ExpenseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    ExpenseRoomDatabase.class,
                                    "Expense_database").build();
                }
            }
        }
        return INSTANCE;
    }

    public void insertRecord(expense_record newRecord) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            Expense_record_dao.insertRecord(newRecord);
        });
        executor.shutdown();
    }
    public void deleteRecord(String expense_decs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            Expense_record_dao.deleteRecord(expense_decs);
        });
        executor.shutdown();
    }
    public void findDecs(String expense_decs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            results = Expense_record_dao.findDecs(expense_decs);
            handler.sendEmptyMessage(0);
        });
        executor.shutdown();

    }
