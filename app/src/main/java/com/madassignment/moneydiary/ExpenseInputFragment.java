package com.madassignment.moneydiary;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
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

import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpenseInputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpenseInputFragment extends Fragment {
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button date;
    DatePickerDialog datePickerDialog;

    public ExpenseInputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpenseInputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpenseInputFragment newInstance(String param1, String param2) {
        ExpenseInputFragment fragment = new ExpenseInputFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_expense_input, container, false);
        Spinner mySpinner = (Spinner) view.findViewById(R.id.spinnerCategory_Expense);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.expenseCategory));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        date = (Button) view.findViewById(R.id.datePicker_Expense);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(getActivity(), (view1, year, monthOfYear, dayOfMonth) -> {
                    // set day of month , month and year value in the edit text
                    date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}