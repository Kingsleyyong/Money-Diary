package com.madassignment.moneydiary.EntityClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "income",
        foreignKeys = {
        @ForeignKey(
                entity = wallet.class,
                parentColumns = "walletId",
                childColumns = "wallet_id"
        )
})
public class income {
    //primary key
    @PrimaryKey(autoGenerate = true)
    private int incomeId;

    @ColumnInfo(name = "Description")
    private String incomeDesc;

    @ColumnInfo(name = "Amount")
    private Float incomeAmount;

    @ColumnInfo(name = "Category")
    private String incomeCategory;

    @ColumnInfo(name = "Picture")
    private Byte[] incomePicture;

    @ColumnInfo(name = "Location")
    private String incomeLocation;

    @ColumnInfo(name = "wallet_ID")
    private int wallet_id;

    public int getIncomeId() {
        return incomeId;
    }

    public String getIncomeDesc() {
        return incomeDesc;
    }

    public void setIncomeDesc(String incomeDesc) {
        this.incomeDesc = incomeDesc;
    }

    public Float getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Float incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(String incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    public Byte[] getIncomePicture() {
        return incomePicture;
    }

    public void setIncomePicture(Byte[] incomePicture) {
        this.incomePicture = incomePicture;
    }

    public String getIncomeLocation() {
        return incomeLocation;
    }

    public void setIncomeLocation(String incomeLocation) {
        this.incomeLocation = incomeLocation;
    }

    public int getWallet_id() {
        return wallet_id;
    }
}
