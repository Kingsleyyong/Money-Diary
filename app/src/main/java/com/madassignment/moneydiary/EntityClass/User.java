package com.madassignment.moneydiary.EntityClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "user",
        foreignKeys = {
        @ForeignKey(
                entity = wallet.class,
                parentColumns = "walletId",
                childColumns = "wallet_ID"
        ),
                @ForeignKey(
                        entity = bill.class,
                        parentColumns = "billId",
                        childColumns = "bill_ID"
                ),
                @ForeignKey(
                        entity = Budgets.class,
                        parentColumns = "budgetId",
                        childColumns = "budget_ID"
                ),
                @ForeignKey(
                        entity = Goals.class,
                        parentColumns = "goalId",
                        childColumns = "goal_ID"
                )
})
public class User {

    //primary key
    @PrimaryKey(autoGenerate = true)
    private int userId;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name="userpassword")
    private String userpassword;

    @ColumnInfo(name = "wallet id")
    private int wallet_ID;

    @ColumnInfo(name = "bill id")
    private int bill_ID;

    @ColumnInfo(name = "budget id")
    private int budget_ID;

    @ColumnInfo(name = "goal id")
    private int goal_ID;

    //getter and setter
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getWallet_ID() {
        return wallet_ID;
    }

    public int getBill_ID() {
        return bill_ID;
    }

    public int getBudget_ID() {
        return budget_ID;
    }


    public int getGoal_ID() {
        return goal_ID;
    }

}
