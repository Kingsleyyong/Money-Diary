package com.madassignment.moneydiary.EntityClass;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "bill")
public class bill {
    //primary key
    @PrimaryKey(autoGenerate = true)
    private int billId;

    //Column
    @ColumnInfo(name = "bills name")
    private String billsName;

    @ColumnInfo(name = "Description")
    private String billsDesc;

    @ColumnInfo(name = "Due date")
    private String billsDueDate;

    @ColumnInfo(name = "Amount")
    private Float billsAmount;

    @ColumnInfo(name = "Status")
    private String billsStatus;

    //getter and setter

    public int getBillId() {
        return billId;
    }

    public String getBillsName() {
        return billsName;
    }

    public void setBillsName(String billsName) {
        this.billsName = billsName;
    }

    public String getBillsDesc() {
        return billsDesc;
    }

    public void setBillsDesc(String billsDesc) {
        this.billsDesc = billsDesc;
    }

    public String getBillsDueDate() {
        return billsDueDate;
    }

    public void setBillsDueDate(String billsDueDate) {
        this.billsDueDate = billsDueDate;
    }

    public Float getBillsAmount() {
        return billsAmount;
    }

    public void setBillsAmount(Float billsAmount) {
        this.billsAmount = billsAmount;
    }

    public String getBillsStatus() {
        return billsStatus;
    }

    public void setBillsStatus(String billsStatus) {
        this.billsStatus = billsStatus;
    }
}
