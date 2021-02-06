package com.madassignment.moneydiary.EntityClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wallet")
public class wallet {
    //primary key
    @PrimaryKey(autoGenerate = true)
    private int walletId;

    @ColumnInfo(name = "wallet Name")
    private String walletName;

    @ColumnInfo(name = "wallet Description")
    private String walletDesc;

    @ColumnInfo(name = "Balance")
    private float walletBalance;

    //getter and setter

    public int getWalletId() {
        return walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getWalletDesc() {
        return walletDesc;
    }

    public void setWalletDesc(String walletDesc) {
        this.walletDesc = walletDesc;
    }

    public Float getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(float walletBalance) {
        this.walletBalance = walletBalance;
    }
}
