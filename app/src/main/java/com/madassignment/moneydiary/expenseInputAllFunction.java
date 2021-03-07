package com.madassignment.moneydiary;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.widget.ArrayAdapter;
import com.madassignment.moneydiary.ui.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

public class expenseInputAllFunction extends Fragment {
    private expenseviewmodel mViewModel;
    private ExpenselistAdapter adapter;
    EditText money;
    Spinner category;
    String category_text;
    DatePicker picker;
    EditText decs;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btnNewRec;

    public static expenseInputAllFunction newInstance() {
        return new expenseInputAllFunction();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expense_input, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(expenseviewmodel.class);
        money = getView().findViewById(R.id.moneyInput_Expense);
        category = getView().findViewById(R.id.spinnerCategory_Expense);
        category_text = category.getSelectedItem().toString();
        picker = getView().findViewById(R.id.datePicker_Expense);
        decs = getView().findViewById(R.id.description_Expense);
        listenerSetup();
        observerSetup();
    }

    private void clearFields() {
        money.setText("");
        decs.setText("");
    }
    
    private void listenerSetup() {
        Button addButton = getView().findViewById(R.id.SubmitRecord_Expense);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String save = money.getText().toString();
                String category = category_text.toString();
                String date = picker.getDayOfMonth() + "/" + (picker.getMonth() + 1) + "/" + picker.getYear();
                String description = decs.getText().toString();

                expense_record ex = new expense_record(category, description,
                        Float.parseFloat(save), date);
                mViewModel.insertRecord(ex);
                clearFields();
            }
        });
    }

    private void observerSetup() {
        mViewModel.getAllRecords().observe(getViewLifecycleOwner(),
                new Observer<List<expense_record>>() {
                    @Override
                    public void onChanged(@Nullable final List<expense_record> records) {
                        adapter.setRecordList(records);
                    }
                });
    }

    private void recyclerSetup() {
    }
}