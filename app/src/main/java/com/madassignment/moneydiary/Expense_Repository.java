package com.madassignment.moneydiary;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import android.app.Application;

public class Expense_Repository {
    private final MutableLiveData<List<expense_record>> searchResults =
            new MutableLiveData<>();
    private List<expense_record> results;
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override public void handleMessage(Message msg) {
            searchResults.setValue(results);
        }
    };
}
