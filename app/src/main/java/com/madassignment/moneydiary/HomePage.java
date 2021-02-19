package com.madassignment.moneydiary;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton menu = findViewById(R.id.fab);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(HomePage.this, R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.botton_sheet_layout,
                        (ViewGroup) findViewById(R.id.bottom_sheet));

                sheetView.findViewById(R.id.imageHome).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Home ImageButton Clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                sheetView.findViewById(R.id.imageManage).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Manage ImageButton Clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                sheetView.findViewById(R.id.imageStat).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Statistic ImageButton Clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                sheetView.findViewById(R.id.imageSettings).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Settings ImageButton Clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                sheetView.findViewById(R.id.buttonLogOut).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, "Logout Button Clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });

        ImageView add = findViewById(R.id.imageAdding);
        add.setOnClickListener(v ->
                Toast.makeText(HomePage.this, "Add Button Clicked", Toast.LENGTH_SHORT).show()
        );

        ImageView search = findViewById(R.id.imageSearch);
        search.setOnClickListener(v ->
                Toast.makeText(HomePage.this, "Search Button Clicked", Toast.LENGTH_SHORT).show()
        );
    }
}
