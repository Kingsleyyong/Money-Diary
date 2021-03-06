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
import androidx.recyclerview.widget.RecyclerView;

public class SignUpPage extends AppCompatActivity {
    UserViewModel userVM;

    UserAdapter userAdapter;

    RecyclerView recyclerView;

    Button btnNewUsr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

//<<<<<<< HEAD
//        userVM = ViewModelProviders.of(this).get(UserViewModel.class);
        userAdapter = new UserAdapter();
        btnNewUsr = findViewById(R.id.signUpButton);

//        userVM.getAllUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(List<User> users) {
//                if(users.size() >0){
//                    userAdapter.setData(users);
//                    recyclerView.setAdapter(userAdapter);
//                }
//            }
//        });
//=======
//        EditText name = findViewById(R.id.usernameSignUpPage);
//        EditText email = findViewById(R.id.emailSignUpPage);
//        EditText pass = findViewById(R.id.passwordSignUpPage);
//        EditText cfmPass = findViewById(R.id.reconfirmPasswordSignUpPage);
//>>>>>>> a07855a760688565955783574ef2fd6b5aed1119

        Button saveButton = findViewById(R.id.signUpButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                saveNewUser(name.getText().toString(),email.getText().toString(),pass.getText().toString(),cfmPass.getText().toString());
            }
        });

//        userVM = ViewModelProviders.of(this).get(UserViewModel.class);
//        userAdapter = new UserAdapter();
//        btnNewUsr = findViewById(R.id.signUpButton);
//
//        userVM.getAllUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(List<User> users) {
//                if(users.size() >0){
//                    userAdapter.setData(users);
//                    recyclerView.setAdapter(userAdapter);
//                }
//            }
//        });

//        btnNewUsr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addUsers(SignUpPage.this);
//            }
//        });

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

    UserAdapter userAdapter;

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

    private void saveNewUser(String name, String email, String pass, String cfmPass){
        UserRoomDatabase db = UserRoomDatabase.getDatabase(this.getApplicationContext());

        User user =new User();
        user.username = name;
        user.email = email;
        user.password = pass;
        user.confirmPassword = cfmPass;
        db.userDao().insertUser(user);

        finish();
    }

//<<<<<<< HEAD
////                userVM.insertUser(user);
//            }
//        });
//=======
//>>>>>>> a07855a760688565955783574ef2fd6b5aed1119

//    private void observerSetup ( ) {
//
//    }
//
//    public void addUsers(Context context){
//        View view1 = getLayoutInflater().inflate(R.layout.activity_sign_up_page, null);
//
//        Button addUsr = view1.findViewById(R.id.signUpButton);
//        addUsr.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                EditText edUsr = view1.findViewById(R.id.usernameSignUpPage);
//                EditText usrEmail = view1.findViewById(R.id.emailSignUpPage);
//                EditText usrPass = view1.findViewById(R.id.passwordSignUpPage);
//
//                User user =new User();
//                user.setUsername(edUsr.getText().toString());
//                user.setEmail(usrEmail.getText().toString());
//                user.setPassword(usrPass.getText().toString());
//
//                userVM.insertUser(user);
//            }
//        });
//
//}

}
