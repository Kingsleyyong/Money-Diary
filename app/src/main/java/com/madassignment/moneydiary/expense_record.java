<<<<<<< HEAD
//package com.madassignment.moneydiary;
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;
//@Entity(tableName = "expense_record")
//
//public class expense_record {
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "expenseId")
//    private int expense_id;
//    @ColumnInfo(name = "expenseCategory")
//    private String expense_cate;
//    @ColumnInfo(name = "expenseDecs")
//    private String expense_decs;
//    @ColumnInfo(name = "expensePrice")
//    private float expense_price;
//
=======
package com.madassignment.moneydiary;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "expense_record")

public class expense_record {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "expenseId")
    public int expense_id;
    @ColumnInfo(name = "expenseCategory")
    public String expense_cate;
    @ColumnInfo(name = "expenseDecs")
    public String expense_decs;
    @ColumnInfo(name = "expensePrice")
    public float expense_price;

>>>>>>> b881b4d65b939d07c178983614f1fd2386a7ff3a
//    public expense_record(String category, String decs, float price) {
//        this.expense_id = expense_id;
//        this.expense_cate = category;
//        this.expense_decs = decs;
//        this.expense_price = price;
//    }
<<<<<<< HEAD
//    public int getExpense_id() {
//        return this.expense_id;
//    }
//    public String getDecs() {
//        return this.expense_decs;
//    }
//    public String getCategory() {
//        return this.expense_cate;
//    }
//    public float getPrice() {
//        return this.expense_price;
//    }
//    public void setExpense_id(int expense_id) {
//        this.expense_id = expense_id;
//    }
//    public void setDesc(String expense_decs) {
//        this.expense_decs = expense_decs;
//    }
//    public void setCate(String expense_cate) {
//        this.expense_cate = expense_cate;
//    }
//    public void setPrice(float expense_price) {
//        this.expense_price = expense_price;
//    }
//}
=======
    public int getExpense_id() {
        return this.expense_id;
    }
    public String getDecs() {
        return this.expense_decs;
    }
    public String getCategory() {
        return this.expense_cate;
    }
    public float getPrice() {
        return this.expense_price;
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
>>>>>>> b881b4d65b939d07c178983614f1fd2386a7ff3a
