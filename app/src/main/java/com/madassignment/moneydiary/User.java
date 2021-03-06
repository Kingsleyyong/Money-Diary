package com.madassignment.moneydiary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")

public class User {

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "userID")
    private int UID;

    @ColumnInfo(name = "userName")
    public String username;

    @ColumnInfo(name = "userEmail")
    public String email;

    @ColumnInfo(name = "userPW")
    public String password;

    @ColumnInfo(name = "userCfPw")
    public String confirmPassword;

//    public User(String username, String email, String password, String confirmPassword) {
//        this.UID = UID;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.confirmPassword = confirmPassword;
//    }

    public int getUID( ) {                  return this.UID;                }
    public String getUsername( ) {          return this.username;           }
    public String getEmail( ) {             return this.email;              }
    public String getPassword( ) {          return this.password;           }
    public String getConfirmPassword( ) {   return this.confirmPassword;    }

    public void setUID (int UID) {                                  this.UID = UID;                             }
    public void setUsername (String username) {                     this.username = username;                   }
    public void setEmail (String email) {                           this.email = email;                         }
    public void setPassword (String password) {                     this.password = password;                   }
    public void setConfirmPassword (String confirmPassword) {       this.confirmPassword = confirmPassword;     }
}
