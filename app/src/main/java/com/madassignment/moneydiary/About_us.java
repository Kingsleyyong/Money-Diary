package com.madassignment.moneydiary;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import com.madassignment.moneydiary.HelperClasses.adapterphone;
import com.madassignment.moneydiary.HelperClasses.phonehelper;

import java.util.ArrayList;

public class About_us extends AppCompatActivity implements adapterphone.ListItemClickListener {

    RecyclerView phoneRecycler;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //Hooks
        phoneRecycler = findViewById(R.id.my_recycler);
        phoneRecycler();

    }

    private void phoneRecycler() {

        //All Gradients
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{0xff7adccf, 0xffdbfffa});
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xffd4cbe5, 0xfff7f2ff});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[]{0xfff7c59f, 0xFFffebdb});
        GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffe6f2ff});
        GradientDrawable gradient5 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{0xfff5b8d1, 0xffffebf3});


        phoneRecycler.setHasFixedSize(true);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        phonelocations.add(new phonehelper(gradient4, R.drawable.lyn_img, "CHAN LIN CHEE", "1191202546"));
        phonelocations.add(new phonehelper(gradient1, R.drawable.jamond_img, "CHEW ZHI PENG", "1191202464"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.koee_img, "HO KO EE", "1191202709"));
        phonelocations.add(new phonehelper(gradient3, R.drawable.matt_img, "MATTHEW LABIAL JOHN", "1191202516"));
        phonelocations.add(new phonehelper(gradient5, R.drawable.kingsley_img, "YONG JING PING", "1191202279"));

        adapter = new adapterphone(phonelocations,this);
        phoneRecycler.setAdapter(adapter);

    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }
}