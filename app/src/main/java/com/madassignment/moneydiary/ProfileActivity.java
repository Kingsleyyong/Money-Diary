package com.madassignment.moneydiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    Button edtBtn,subBtn;
    String LoggedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        LoggedName = getIntent().getStringExtra("name");
//        Toast.makeText(this, LoggedName, Toast.LENGTH_SHORT).show();

        edtBtn = findViewById(R.id.editProfileBtn);
        subBtn = findViewById(R.id.submitBtn);
        edtBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout2, new NonEditableUserData());
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(v.getId() == R.id.editProfileBtn){
            edtBtn.setVisibility(View.GONE);
            subBtn.setVisibility(View.VISIBLE);

            ft.replace(R.id.frameLayout2, new EditableUserData());
            ft.commit();
        }

        if(v.getId() == R.id.submitBtn){
            edtBtn.setVisibility(View.VISIBLE);
            subBtn.setVisibility(View.GONE);

            ft.replace(R.id.frameLayout2, new NonEditableUserData());
            ft.commit();
        }
    }
}