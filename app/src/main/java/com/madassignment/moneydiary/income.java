package com.madassignment.moneydiary;

public class income {
    private int incomeID;
    private String incomeDesc;
    private double incomeAmt;
    private String incomeCate;
    private String incomePic;
    private String incomeLocation;

    public income(String incomeDesc, double incomeAmt, String incomeCate, String incomePic, String incomeLocation) {
        this.incomeDesc = incomeDesc;
        this.incomeAmt = incomeAmt;
        this.incomeCate = incomeCate;
        this.incomePic = incomePic;
        this.incomeLocation = incomeLocation;
    }

    public income(int incomeID, String incomeDesc, double incomeAmt, String incomeCate, String incomePic, String incomeLocation) {
        this.incomeID = incomeID;
        this.incomeDesc = incomeDesc;
        this.incomeAmt = incomeAmt;
        this.incomeCate = incomeCate;
        this.incomePic = incomePic;
        this.incomeLocation = incomeLocation;
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

    public String getincomePic() {
        return incomePic;
    }

    public void setincomePic(String incomePic) {
        this.incomePic = incomePic;
    }

    public String getincomeLocation() {
        return incomeLocation;
    }

    public void setincomeLocation(String incomeLocation) {
        this.incomeLocation = incomeLocation;
    }
}
