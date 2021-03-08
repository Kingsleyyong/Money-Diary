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

    @Query("SELECT * FROM user WHERE userName=(:userName) and userPW=(:password)")
    User login(String userName, String password);

    @Query("SELECT * FROM user WHERE userEmail = (:email) ")
    User CheckUser(String email);

    @Query("SELECT * FROM user WHERE userName = (:username)")
    User FindUsername(String username);

    @Query("SELECT * FROM user WHERE userID = (:uid) ")
    User UserById(int uid);

    @Query("UPDATE user SET userPW = 'ABC123' , userCfPw = 'ABC123' WHERE userEmail= (:usrEmail)")
    void resetPassword(String usrEmail);

    @Query("UPDATE user SET userName=:uname , userEmail=:uemail, userPW=:upass , userCfPw=:uconpass WHERE userID=:uid")
    void editProfile(String uname, String uemail, String upass, String uconpass, int uid);

    @Query("SELECT * FROM user WHERE userEmail = :email ")
    List<User>findUser(String email);

    @Query("DELETE FROM user WHERE userEmail = :email ")
    void deleteUser(String email);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUser();
}
