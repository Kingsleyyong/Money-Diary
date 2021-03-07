package com.madassignment.moneydiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInPage extends AppCompatActivity {

    EditText namee, pass;
    Button signInButton;

    String LoggedInName = "";

    ProfileActivity profile = new ProfileActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        Button forgotPassButton = findViewById(R.id.forgotPassButton);
        Button signUpButton = findViewById(R.id.signUpButton);

        namee = findViewById(R.id.editTextTextUsername);
        pass = findViewById(R.id.editTextTextPassword);
        signInButton = findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_text = namee.getText().toString();
                String pass_text = pass.getText().toString();

                if(name_text.isEmpty() || pass_text.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    UserRoomDatabase db = UserRoomDatabase.getDatabase(getApplicationContext());
                    final UserDao userDao = db.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.login(name_text,pass_text);
                            if(user == null)
                            {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else{
//                                String name = user.username;
                                LoggedInName = user.username;
                                startActivity(new Intent(SignInPage.this, HomePage.class).putExtra("name",LoggedInName));
                            }
                        }
                    }).start();
                }
            }
        });

        forgotPassButton.setOnClickListener(v -> {
            //getApplicationContext() return the whole Application
            Intent i = new Intent(getApplicationContext(), ForgetPassword.class);
            startActivity(i);
        });

        signUpButton.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), SignUpPage.class);
            startActivity(i);
        });

    }
}
