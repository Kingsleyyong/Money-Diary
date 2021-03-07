package com.madassignment.moneydiary;

public class income {
    private int incomeID;
    private String incomeDesc;
    private double incomeAmt;
    private String incomeCate;
    private String incomeDate;

    public income(String incomeDesc, double incomeAmt, String incomeCate, String incomeDate) {
        this.incomeDesc = incomeDesc;
        this.incomeAmt = incomeAmt;
        this.incomeCate = incomeCate;
        this.incomeDate = incomeDate;
    }

    public income(int incomeID, String incomeDesc, double incomeAmt, String incomeCate, String incomeDate) {
        this.incomeID = incomeID;
        this.incomeDesc = incomeDesc;
        this.incomeAmt = incomeAmt;
        this.incomeCate = incomeCate;
        this.incomeDate = incomeDate;
    }

    public int getincomeID() {
        return incomeID;
    }

    public String getincomeDesc() {
        return incomeDesc;
    }

    public void setincomeDesc(String incomeDesc) {
        this.incomeDesc = incomeDesc;
    }

    public double getincomeAmt() {
        return incomeAmt;
    }

    public void setincomeAmt(double incomeAmt) {
        this.incomeAmt = incomeAmt;
    }

    public String getincomeCate() {
        return incomeCate;
    }

    public void setincomeCate(String incomeCate) {
        this.incomeCate = incomeCate;
    }

    public String getincomeDate() {
        return incomeDate;
    }

    public void setincomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }

}
