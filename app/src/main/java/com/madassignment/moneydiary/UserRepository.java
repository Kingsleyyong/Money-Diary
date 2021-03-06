package com.madassignment.moneydiary;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class UserRepository {

    private final MutableLiveData<List<User>> searchResults =
            new MutableLiveData<>();

    private List<User> results;

    private final LiveData<List<User>> allUsers;

    private final UserDao userDao;

    public UserRepository(Application application) {
        UserRoomDatabase db;
        db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        allUsers = userDao.getAllUser();
    }

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            searchResults.setValue(results);
        }
    };

    public void insertUser (User newUser) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            userDao.insertUser(newUser);
        });
        executor.shutdown();
    }

    public void findUser(String email) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            results = userDao.findUser(email);
            handler.sendEmptyMessage(0);
        });
        executor.shutdown();
    }

    public void deleteUser(String email) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            userDao.deleteUser(email);
        });
        executor.shutdown();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public MutableLiveData<List<User>> getSearchResults() {
        return searchResults;
    }
}
