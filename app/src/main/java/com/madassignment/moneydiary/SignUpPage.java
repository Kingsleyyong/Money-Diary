package com.madassignment.moneydiary;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity {

    UserDatabase mDatabaseHelper;
    private EditText username, email, password, confirmPassword;
    private Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout(width,height);
//
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.gravity = Gravity.CENTER;
//        params.x = 0;
//        params.y = 0;
//        getWindow().setAttributes(params);

        username = (EditText) findViewById(R.id.usernameSignUpPage);
        email = (EditText) findViewById(R.id.emailSignUpPage);
        password = (EditText) findViewById(R.id.passwordSignUpPage);
        confirmPassword = (EditText) findViewById(R.id.reconfirmPasswordSignUpPage);
        signUpBtn = (Button) findViewById(R.id.signUpButton);
        mDatabaseHelper = new UserDatabase(this);





        TextView textView = findViewById(R.id.textViewSignUpPage);
        String text = "By creating an account, you will be agreed to our Terms & Conditions and Privacy & Policy.";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                //Please do something here to give performance for 'here' text.
                Toast.makeText(SignUpPage.this, "Terms & Conditions Clicked", Toast.LENGTH_SHORT).show();

            }

            //This is the style settings
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setFakeBoldText(true);
            }
        };


        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setFakeBoldText(true);
            }

            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(SignUpPage.this, "Privacy & Policy Clicked", Toast.LENGTH_SHORT).show();
            }
        };

        ss.setSpan(clickableSpan1, 50, 68, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan2, 73, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void AddData(String name, String mail, String pw, String cfpw) {
        boolean insertData = mDatabaseHelper.addData(name,mail,pw,cfpw);

        if(insertData) {
            toastMessage("Data Successfully Inserted");
        }
        else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
