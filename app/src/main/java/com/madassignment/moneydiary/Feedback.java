package com.madassignment.moneydiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Feedback extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    Uri uri1 = Uri.parse("https://www.facebook.com");
    Uri uri2 = Uri.parse("https://www.instagram.com");
    Uri uri3 = Uri.parse("https://twitter.com");
    Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
    Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
    Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ImageView fbPic = (ImageView) findViewById(R.id.fbimg);
        fbPic.setOnClickListener(this);
        ImageView instaPic = (ImageView) findViewById(R.id.instaimg);
        instaPic.setOnClickListener(this);
        ImageView twitterPic = (ImageView) findViewById(R.id.twitterimg);
        twitterPic.setOnClickListener(this);
        TextView fbBtn = (TextView) findViewById(R.id.fblink);
        fbBtn.setOnClickListener(this);
        TextView instaBtn = (TextView) findViewById(R.id.iglink);
        instaBtn.setOnClickListener(this);
        TextView twitterBtn = (TextView) findViewById(R.id.twitterlink);
        twitterBtn.setOnClickListener(this);

        TextView feedback = findViewById(R.id.feedbackLabel);
        String fbTxt = "Feel free to drop us your feedback.";
        SpannableString spanFb = new SpannableString(fbTxt);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"moneydiary_official@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Money Diary - Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, "Your Message: ");

                try {
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(Feedback.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setFakeBoldText(true);
            }
        };

        spanFb.setSpan(clickableSpan1, 26, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        feedback.setText(spanFb);
        feedback.setMovementMethod(LinkMovementMethod.getInstance());

    }

    @Override
    public void onMapReady(GoogleMap mMap) {

        LatLng mmu = new LatLng(2.926386, 101.641144);
        mMap.addMarker(new MarkerOptions().position(mmu)
                .title("DIT5851").snippet("Mobile Application Development"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mmu, 17));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this, permissions, 0);

            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fbimg:
            case R.id.fblink: startActivity(intent1); break;
            case R.id.iglink:
            case R.id.instaimg: startActivity(intent2); break;
            case R.id.twitterimg:
            case R.id.twitterlink:  startActivity(intent3); break;
        }
    }
}