package com.madassignment.moneydiary.EntityClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.android.material.internal.NavigationMenu;

@Entity(tableName = "Expense", foreignKeys = {
        @ForeignKey(
                entity = wallet.class,
                parentColumns = "walletId",
                childColumns = "wallet_Id"
        )
})
public class Expense {

    //setting pk to autogenerate
    @PrimaryKey(autoGenerate = true)
    private int expenseId;

    @ColumnInfo(name = "Description")
    private String expenseDesc;

    @ColumnInfo(name = "Amount")
    private float expenseAmount;

    @ColumnInfo(name = "Category")
    private String expenseCategory;

    @ColumnInfo(name = "Picture")
    private Byte[] expensePicture;

    @ColumnInfo(name = "Location")
    private String expenseLocation;

    @ColumnInfo(name = "wallet id")
    private int wallet_Id;

    //getter and setter

    public int getExpenseId() {
        return expenseId;
    }

    public String getExpenseDesc() {
        return expenseDesc;
    }

    public void setExpenseDesc(String expenseDesc) {
        this.expenseDesc = expenseDesc;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Byte[] getExpensePicture() {
        return expensePicture;
    }

    public void setExpensePicture(Byte[] expensePicture) {
        this.expensePicture = expensePicture;
    }

    public String getExpenseLocation() {
        return expenseLocation;
    }

    public void setExpenseLocation(String expenseLocation) {
        this.expenseLocation = expenseLocation;
    }

    public int getWallet_Id() {
        return wallet_Id;
    }

}
