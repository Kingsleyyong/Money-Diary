package com.madassignment.moneydiary;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao

public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE userEmail = :email ")
    List<User>findUser(String email);

    @Query("DELETE FROM user WHERE userEmail = :email ")    // suitable?
    void deleteUser(String email);                       // suitable?

    @Query("SELECT * FROM user")        // suitable?
    LiveData<List<User>> getAllUser();  // suitable?
}
