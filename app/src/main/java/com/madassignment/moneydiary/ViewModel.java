package com.madassignment.moneydiary;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    UserRepository userRepository;
    LiveData<List<User>> userList;
    MutableLiveData<List<User>> searchResult;

    public ViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        userList = userRepository.getAllUsers();
        searchResult = userRepository.getSearchResults();
    }

    public LiveData<List<User>> getALLUser(){
        return userRepository.getAllUsers();
    }

    public void insertUser(User user){
        userRepository.insertUser(user);
    }

    MutableLiveData<List<User>> getSearchResults() {
        return searchResult;
    }

    public void findUser(String email) {
        userRepository.findUser(email);
    }
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }
}
