package com.madassignment.moneydiary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncomeInputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IncomeInputFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IncomeInputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IncomeInputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IncomeInputFragment newInstance(String param1, String param2) {
        IncomeInputFragment fragment = new IncomeInputFragment();
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

        View view = inflater.inflate(R.layout.fragment_income_input, container, false);
        Spinner mySpinner =  view.findViewById(R.id.spinnerCategory_Income);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.incomeCategory));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        Button submit = view.findViewById(R.id.SubmitRecord_Income);
        DatePicker date = view.findViewById(R.id.datePicker_Income);
        EditText money = view.findViewById(R.id.moneyInput_Income);
        EditText desc = view.findViewById(R.id.description_Income);
        long datep = date.getCalendarView().getDate();

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                incomeDAO dao = new incomeDAO(getContext());
                boolean yay = true;

                if (desc.getText().toString().matches("")){
                    yay = false;
                }

                if (yay) {
                    income rec = new income(desc.getText().toString(), Double.valueOf(money.getText().toString()), mySpinner.getSelectedItem().toString(),datep);
                    yay = dao.addOne(rec);
                }

                if (yay){
                    Toast.makeText(getContext(),"Success!",Toast.LENGTH_SHORT).show();
                } else if (!yay){
                    Toast.makeText(getContext(),"Failed, have you entered a description?",Toast.LENGTH_LONG).show();
                }

            }
        });

        // Inflate the layout for this fragment
        return view;
    }


}
