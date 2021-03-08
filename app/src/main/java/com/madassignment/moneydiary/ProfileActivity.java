package com.madassignment.moneydiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    Button edtBtn,subBtn, mainBtn;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        uid = getIntent().getStringExtra("uid");

        edtBtn = findViewById(R.id.editProfileBtn);
        subBtn = findViewById(R.id.submitBtn);
        mainBtn = findViewById(R.id.backToMainBtn);

        edtBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mainBtn.setOnClickListener(this);

        FragmentManager fm = getSupportFragmentManager();
        NonEditableUserData newFrag = new NonEditableUserData();
        fm.beginTransaction().replace(R.id.frameLayout2, newFrag).commit();

        Bundle b = new Bundle();
        b.putString("userID", uid);

        newFrag.setArguments(b);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.editProfileBtn){

            FragmentManager fm = getSupportFragmentManager();
            EditableUserData newFrag = new EditableUserData();
            fm.beginTransaction().replace(R.id.frameLayout2, newFrag).commit();

            Bundle b = new Bundle();
            b.putString("userID", uid);

            newFrag.setArguments(b);

            edtBtn.setVisibility(View.GONE);
            subBtn.setVisibility(View.VISIBLE);
        }

        if(v.getId() == R.id.submitBtn){

            EditText n = findViewById(R.id.editProfileName);
            EditText e = findViewById(R.id.editProfileEmail);
            EditText p = findViewById(R.id.editProfilePass);
            EditText cp = findViewById(R.id.editProfileReconfirm);

            String name = n.getText().toString();
            String email = e.getText().toString();
            String pass = p.getText().toString();
            String conPass = cp.getText().toString();

            int ID = Integer.parseInt(uid);

            if( name.isEmpty() || email.isEmpty() || pass.isEmpty() || conPass.isEmpty() ) {
                Toast.makeText(ProfileActivity.this, "Please Fill In All Details!", Toast.LENGTH_SHORT).show();
            }
            else {

                if(!pass.equals(conPass)) {
                    Toast.makeText(ProfileActivity.this, "Passwords Not Same", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserRoomDatabase db = UserRoomDatabase.getDatabase(getApplicationContext());
                    final UserDao userDao = db.userDao();
                    userDao.editProfile(name, email, pass, conPass, ID);

                    edtBtn.setVisibility(View.VISIBLE);
                    subBtn.setVisibility(View.GONE);

                    FragmentManager fm = getSupportFragmentManager();
                    NonEditableUserData newFrag = new NonEditableUserData();
                    fm.beginTransaction().replace(R.id.frameLayout2, newFrag).commit();

                    Bundle b = new Bundle();
                    b.putString("userID", uid);

                    newFrag.setArguments(b);
                }

            }
        }

        if(v.getId() == R.id.backToMainBtn) {
            this.onBackPressed();
        }
    }
}