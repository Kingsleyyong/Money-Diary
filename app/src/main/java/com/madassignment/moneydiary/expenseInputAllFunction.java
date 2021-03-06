package com.madassignment.moneydiary;

import android.os.Bundle;

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

import androidx.lifecycle.ViewModelProvider;

import java.sql.Date;

public class expenseInputAllFunction extends AppCompatActivity {
    private expenseviewmodel mViewModel;
    private ExpenselistAdapter adapter;
    private TextView expenseId;
    private EditText expenseDecs;
    private EditText expenseName;
    private EditText expensePrice;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_expense_input);

        EditText money = findViewById(R.id.moneyInput_Expense);
        Spinner category = (Spinner) findViewById(R.id.spinnerCategory_Expense);
        String category_text = category.getSelectedItem().toString();
        DatePicker picker = (DatePicker)findViewById(R.id.datePicker_Expense);
        EditText decs = findViewById(R.id.description_Expense);

        Button saveButton = findViewById(R.id.ExpenseBtn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear();

                new expense_record(category_text, decs.getText().toString(),
                        Float.parseFloat(String.valueOf(money.getText())), date);

                Toast.makeText(expenseInputAllFunction.this, date, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
