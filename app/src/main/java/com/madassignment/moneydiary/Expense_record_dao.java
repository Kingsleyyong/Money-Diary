//package com.madassignment.moneydiary;
//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.Query;
//import java.util.List;
//
//@Dao
//public interface Expense_record_dao {
//    @Insert
//    void insertProduct(expense_record product);
//    @Query("SELECT * FROM expense_record WHERE expenseDecs = :expense_decs")
//    List<expense_record> findDecs(String expense_decs);
//    @Query("DELETE FROM expense_record WHERE expenseDecs = :expense_decs")
//    void deleteRecord(String expense_decs);
//    @Query("SELECT * FROM expense_record")
//    LiveData<List<expense_record>> getAllDetails();
//}
