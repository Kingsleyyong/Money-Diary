package com.madassignment.moneydiary;

public class expense_record {
    private int expense_id;
    private String expense_cate;
    private String expense_decs;
    private double expense_price;
    private String expense_date;
    private int userID;

    public expense_record(String expense_decs, double expense_price, String expense_cate, String expense_date, int userID) {
        this.expense_decs = expense_decs;
        this.expense_price = expense_price;
        this.expense_cate = expense_cate;
        this.expense_date = expense_date;
        this.userID = userID;
    }

    public expense_record(int expense_id, String expense_decs, double expense_price,
                          String expense_cate, String expense_date, int userID) {
        this.expense_id = expense_id;
        this.expense_decs = expense_decs;
        this.expense_price = expense_price;
        this.expense_cate = expense_cate;
        this.expense_date = expense_date;
        this.userID = userID;
    }

    public int getExpense_id() {
        return this.expense_id;
    }
    public String getDecs() {
        return this.expense_decs;
    }
    public String getCategory() {
        return this.expense_cate;
    }
    public double getPrice() {
        return this.expense_price;
    }
    public String getDate() {
        return this.expense_date;
    }
    public int getUserID() {return  this.userID; }

}


