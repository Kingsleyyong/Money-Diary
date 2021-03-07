package com.madassignment.moneydiary;

public class expense_record {
    public int expense_id;
    public String expense_cate;
    public String expense_decs;
    public double expense_price;
    public String expense_date;

    public expense_record(String expense_decs, double expense_price, String expense_cate, String expense_date) {
        this.expense_decs = expense_decs;
        this.expense_price = expense_price;
        this.expense_cate = expense_cate;
        this.expense_date = expense_date;
    }

    public expense_record(int expense_id, String expense_decs, double expense_price,
                          String expense_cate, String expense_date) {
        this.expense_id = expense_id;
        this.expense_decs = expense_decs;
        this.expense_price = expense_price;
        this.expense_cate = expense_cate;
        this.expense_date = expense_date;
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
    public void setExpense_date(String expense_date) {
        this.expense_date = expense_date;
    }
    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }
    public void setDesc(String expense_decs) {
        this.expense_decs = expense_decs;
    }
    public void setCate(String expense_cate) {
        this.expense_cate = expense_cate;
    }
    public void setPrice(float expense_price) {
        this.expense_price = expense_price;
    }
}


