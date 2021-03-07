package com.madassignment.moneydiary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    ImageView aboutus, feedback;
    TextView usrname;

    RecyclerView incomeRecycler;
    incomeRecAdapter incomeRecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        usrname = findViewById(R.id.textUsername);
        String name = getIntent().getStringExtra("name");
        usrname.setText(name);

        // Income setup
        incomeDAO incomedao = new incomeDAO(this);

        TextView totalincome = findViewById(R.id.incomeNumber);
        totalincome.setText((Double.toString(incomedao.totalIncome())));

        incomeRecycler = findViewById(R.id.incomeRec);
        incomeRecAdapter = new incomeRecAdapter();
        incomeRecAdapter.setCtx(this);

        incomeRecycler.setAdapter(incomeRecAdapter);

        FloatingActionButton menu = findViewById(R.id.fab);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(HomePage.this, R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.botton_sheet_layout,
                        (ViewGroup) findViewById(R.id.bottom_sheet));

                sheetView.findViewById(R.id.imageManage).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Profile ImageButton Clicked", Toast.LENGTH_SHORT).show();
                        Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(profile);
                    }
                });

                sheetView.findViewById(R.id.imageSettings).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Settings ImageButton Clicked", Toast.LENGTH_SHORT).show();
                        createNewSettingDialog();
                    }
                });

                sheetView.findViewById(R.id.buttonLogOut).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Logout Button Clicked", Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                        builder.setTitle("Confirmation: ").
                                setMessage("Are you sure to proceed log out?");
                        builder.setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent i = new Intent(getApplicationContext(),
                                                LoadingScreen.class);
                                        startActivity(i);
                                    }
                                });
                        builder.setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });

        ImageView add = findViewById(R.id.imageAdding);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, addRecord.class);
                startActivity(i);
            }
        });

    }

    public void createNewSettingDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View settingPopUp = getLayoutInflater().inflate(R.layout.setting_pop_up,null);


        aboutus = (ImageView) settingPopUp.findViewById(R.id.aboutUsImage);
        feedback = (ImageView) settingPopUp.findViewById(R.id.feedbackImage);

        dialogBuilder.setView(settingPopUp);
        dialog = dialogBuilder.create();
        dialog.show();

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "About Us", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HomePage.this, About_us.class);
                startActivity(i);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Feedback", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HomePage.this, Feedback.class);
                startActivity(i);
            }
        });
    }
}
