//package com.madassignment.moneydiary.ui;
//import android.app.Application;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.AndroidViewModel;
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import com.madassignment.moneydiary.expense_record;
//import com.madassignment.moneydiary.Expense_Repository;
//import java.util.List;
//
//public class expenseviewmodel extends AndroidViewModel{
//
//    private Expense_Repository er;
//    private LiveData<List<expense_record>> allRecords;
//    private MutableLiveData<List<expense_record>> searchResults;
//    public expenseviewmodel (Application application) {
//        super(application);
//        er = new Expense_Repository(application);
//        allRecords = er.getAllRecords();
//        searchResults = er.getSearchResults();
//    }
//    MutableLiveData<List<expense_record>> getSearchResults() {
//        return searchResults;
//    }
//    LiveData<List<expense_record>> getAllRecords() {
//        return allRecords;
//    }
//    public void insertRecord(expense_record record) {
//        er.insertRecord(record);
//    }
//    public void findDecs(String decs) {
//        er.findDecs(decs);
//    }
//    public void deleteRecord(String record) {
//        er.deleteRecord(record);
//    }
//}
