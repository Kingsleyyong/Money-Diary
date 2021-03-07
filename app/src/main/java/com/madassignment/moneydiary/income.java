package com.madassignment.moneydiary;

public class income {
    private int incomeID;
    private String incomeDesc;
    private double incomeAmt;
    private String incomeCate;
    private String incomeDate;
    private int userID;

    public income(String incomeDesc, double incomeAmt, String incomeCate, String incomeDate, int userID) {
        this.incomeDesc = incomeDesc;
        this.incomeAmt = incomeAmt;
        this.incomeCate = incomeCate;
        this.incomeDate = incomeDate;
        this.userID = userID;
    }

    public income(int incomeID, String incomeDesc, double incomeAmt, String incomeCate, String incomeDate, int userID) {
        this.incomeID = incomeID;
        this.incomeDesc = incomeDesc;
        this.incomeAmt = incomeAmt;
        this.incomeCate = incomeCate;
        this.incomeDate = incomeDate;
        this.userID = userID;
    }

    public int getincomeID() {
        return incomeID;
    }

    public String getincomeDesc() {
        return incomeDesc;
    }

    public double getincomeAmt() {
        return incomeAmt;
    }

    public String getincomeCate() {
        return incomeCate;
    }

    public String getincomeDate() {
        return incomeDate;
    }

    public int getUserID() {return userID;}

}