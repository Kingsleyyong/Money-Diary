package com.madassignment.moneydiary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class addRecord extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        Button incomeBtn = findViewById(R.id.IncomeBtn);
        Button expenseBtn = findViewById(R.id.ExpenseBtn);

        incomeBtn.setOnClickListener(this);
        expenseBtn.setOnClickListener(this);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new ExpenseInputFragment());
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch(v.getId()){
            case R.id.IncomeBtn:
                Toast.makeText(this,"Income",Toast.LENGTH_SHORT).show();
                ft.replace(R.id.frameLayout, new IncomeInputFragment());
                ft.commit();
                break;
            case R.id.ExpenseBtn:
                Toast.makeText(this,"Expense",Toast.LENGTH_SHORT).show();
                ft.replace(R.id.frameLayout, new ExpenseInputFragment());
                ft.commit();
                break;
        }
    }
}