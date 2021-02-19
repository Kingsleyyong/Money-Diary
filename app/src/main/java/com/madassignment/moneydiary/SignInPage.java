package com.madassignment.moneydiary;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SignInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        Button forgotPassButton = findViewById(R.id.forgotPassButton);
        Button signUpButton = findViewById(R.id.signUpButton);
        Button signInButton = findViewById(R.id.signInButton);

        forgotPassButton.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), ForgetPassword.class);
            startActivity(i);
        });

        signUpButton.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), SignUpPage.class);
            startActivity(i);
        });

        signInButton.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), HomePage.class);
            startActivity(i);
        });
    }
}
