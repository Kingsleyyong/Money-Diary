package com.madassignment.moneydiary;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
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

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
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


        Button resetPwBtn = findViewById(R.id.resetPassBtn);
        resetPwBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v){
                        EditText resetEmail = findViewById(R.id.emailForReset);
                        String rsEmail = resetEmail.getText().toString();

                        if(rsEmail.equals("") || rsEmail == null) {
                            Toast.makeText(ForgetPassword.this, "Please insert an email", Toast.LENGTH_SHORT).show();
                        }
//                        else if( ){
//                            email not existing
//                        }
                        else {
                            resetPwBtn.setEnabled(false);

                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "moneydiary_official@gmail.com" } );
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Money Diary App Reset Password");
                            intent.putExtra(Intent.EXTRA_TEXT, "Your password had been reset to ABC123. Please reset your password after logging in. \n" +
                                    "\n Please send us an email if you have any problems.");

                            try {
                                startActivity(Intent.createChooser(intent, "Send mail..."));
                            } catch (android.content.ActivityNotFoundException ex) {
                                Toast.makeText(ForgetPassword.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }
                }
        );

    }

}