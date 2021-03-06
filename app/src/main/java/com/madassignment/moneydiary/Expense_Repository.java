package com.madassignment.moneydiary;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import android.app.Application;

public class Expense_Repository {
    private final MutableLiveData<List<expense_record>> searchResults =
            new MutableLiveData<>();
    private List<expense_record> results;
    private final LiveData<List<expense_record>> allRecords;
    private final Expense_record_dao ExpenseDao;
    public Expense_Repository(Application application) {
        ExpenseRoomDatabase db;
        db = ExpenseRoomDatabase.getDatabase(application);
        ExpenseDao = db.expenseRecordDao();
        allRecords =ExpenseDao.getAllDetails();
    }
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override public void handleMessage(Message msg) {
            searchResults.setValue(results);
        }
    };

    public void insertRecord(expense_record newRecord) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            ExpenseDao.insertRecord(newRecord);
        });
        executor.shutdown();
    }
    public void deleteRecord(String decs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            ExpenseDao.deleteRecord(decs);
        });
        executor.shutdown();
    }
    public void findDecs(String decs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            results = ExpenseDao.findDecs(decs);
            handler.sendEmptyMessage(0);
        });
        executor.shutdown();
    }

    public LiveData<List<expense_record>> getAllRecords() {
        return allRecords;
    }
    public MutableLiveData<List<expense_record>> getSearchResults() {
        return searchResults;
    }
}
