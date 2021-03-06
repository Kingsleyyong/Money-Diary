package com.madassignment.moneydiary;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.madassignment.moneydiary.User;
import com.madassignment.moneydiary.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;
    private MutableLiveData<List<User>> searchResult;

    public UserViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
        searchResult = userRepository.getSearchResults();
    }

    MutableLiveData<List<User>> getSearchResults() {
        return searchResult;
    }

    LiveData<List<User>> getAllUsers() { return userRepository.getAllUsers(); }

    public void findUser(String email) {
        userRepository.findUser(email);
    }
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }
    public void insertUser(User user){
        userRepository.insertUser(user);
    }
}
