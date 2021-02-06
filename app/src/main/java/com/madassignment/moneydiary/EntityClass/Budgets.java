package com.madassignment.moneydiary.EntityClass;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Budget")
public class Budgets {

    @PrimaryKey(autoGenerate = true)
    private int budgetId;

    @ColumnInfo(name = "Budget Name")
    private String budgetName;

    @ColumnInfo(name = "Amount")
    private float budgetAmount;

    @ColumnInfo(name = "Category")
    private String budgetCategory;

    @ColumnInfo(name = "Period")
    private String budgetPeriod;

    //getter and setter

    public int getBudgetId() {
        return budgetId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public float getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(float budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getBudgetCategory() {
        return budgetCategory;
    }

    public void setBudgetCategory(String budgetCategory) {
        this.budgetCategory = budgetCategory;
    }

    public String getBudgetPeriod() {
        return budgetPeriod;
    }

    public void setBudgetPeriod(String budgetPeriod) {
        this.budgetPeriod = budgetPeriod;
    }
}
