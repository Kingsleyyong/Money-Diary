package com.madassignment.moneydiary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    Button edtBtn,subBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        Button editBtn = findViewById(R.id.editProfileBtn);
        subBtn = findViewById(R.id.submitBtn);
        editBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout2, new NonEditableUserData());
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(v.getId() == R.id.editProfileBtn){
            edtBtn = findViewById(R.id.editProfileBtn);
            edtBtn.setVisibility(View.GONE);

            subBtn = findViewById(R.id.submitBtn);
            subBtn.setVisibility(View.VISIBLE);

            ft.replace(R.id.frameLayout2, new EditableUserData());
            ft.commit();
        }

        if(v.getId() == R.id.submitBtn){
            edtBtn = findViewById(R.id.editProfileBtn);
            edtBtn.setVisibility(View.VISIBLE);

            subBtn = findViewById(R.id.submitBtn);
            subBtn.setVisibility(View.GONE);

            ft.replace(R.id.frameLayout2, new NonEditableUserData());
            ft.commit();
        }
    }
}