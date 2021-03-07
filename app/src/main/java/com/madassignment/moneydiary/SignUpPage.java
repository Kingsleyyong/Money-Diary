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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class SignUpPage extends AppCompatActivity {

    UserAdapter userAdapter;

    RecyclerView recyclerView;

    Button btnNewUsr;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        userAdapter = new UserAdapter();
        btnNewUsr = findViewById(R.id.signUpButton);


        EditText uName = findViewById(R.id.usernameSignUpPage);
        EditText uEmail = findViewById(R.id.emailSignUpPage);
        EditText uPass = findViewById(R.id.passwordSignUpPage);
        EditText uCfmPass = findViewById(R.id.reconfirmPasswordSignUpPage);

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Button saveButton = findViewById(R.id.signUpButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = uName.getText().toString();
                String email = uEmail.getText().toString();
                String pass = uPass.getText().toString();
                String cfmPass = uCfmPass.getText().toString();

                if( name.length()!=0 && email.length()!=0 && pass.length()!=0 && cfmPass.length()!=0 ) {

                    if (email.trim().matches(emailPattern)) {
                        saveNewUser(name, email, pass, cfmPass);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SignUpPage.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                }
            }
        });


    UserAdapter userAdapter;

        TextView textView = findViewById(R.id.textViewSignUpPage);
        String text = "By creating an account, you will be agreed to our Terms & Conditions and Privacy Policy.";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                //Please do something here to give performance for 'here' text.
                Toast.makeText(SignUpPage.this, "Terms & Conditions Clicked", Toast.LENGTH_SHORT).show();
                createNewTnCDialog();
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
                Toast.makeText(SignUpPage.this, "Privacy Policy Clicked", Toast.LENGTH_SHORT).show();
                createNewPnPDialog();
            }
        };

        ss.setSpan(clickableSpan1, 50, 68, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan2, 73, 87, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void createNewTnCDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View tncpopup = getLayoutInflater().inflate(R.layout.tnc_popup,null);

        dialogBuilder.setView(tncpopup);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void createNewPnPDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View pnppopup = getLayoutInflater().inflate(R.layout.pnp_popup,null);

        dialogBuilder.setView(pnppopup);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    private void saveNewUser(String name, String email, String pass, String cfmPass){
        UserRoomDatabase db = UserRoomDatabase.getDatabase(this.getApplicationContext());

        User user =new User();
        user.username = name;
        user.email = email;
        user.password = pass;
        user.confirmPassword = cfmPass;
        db.userDao().insertUser(user);

        Toast.makeText(SignUpPage.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
