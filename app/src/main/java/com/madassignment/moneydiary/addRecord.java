package com.madassignment.moneydiary;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

//import com.madassignment.moneydiary.ExpenseInputFragment;

public class addRecord extends AppCompatActivity implements View.OnClickListener {

    Button incomeBtn, expenseBtn;
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        incomeBtn = findViewById(R.id.IncomeBtn);
        expenseBtn = findViewById(R.id.ExpenseBtn);

        incomeBtn.setOnClickListener(this);
        expenseBtn.setOnClickListener(this);

        userID = getIntent().getIntExtra("userID", -1);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new ExpenseInputFragment());
        incomeBtn.setBackgroundColor(Color.parseColor("#899974"));
        ft.commit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch(v.getId()){
            case R.id.IncomeBtn:
                Toast.makeText(this,"Income Add Record",Toast.LENGTH_SHORT).show();
                incomeBtn.setBackgroundColor(Color.parseColor("#7cad3e"));
                expenseBtn.setBackgroundColor(Color.parseColor("#899974"));

                ft.replace(R.id.frameLayout, new IncomeInputFragment(userID));
                ft.commit();
                break;

            case R.id.ExpenseBtn:
                Toast.makeText(this,"Expense Add Record",Toast.LENGTH_SHORT).show();
                expenseBtn.setBackgroundColor(Color.parseColor("#7cad3e"));
                incomeBtn.setBackgroundColor(Color.parseColor("#899974"));

                ft.replace(R.id.frameLayout, new ExpenseInputFragment(userID));
                ft.commit();
                break;
        }
    }
}