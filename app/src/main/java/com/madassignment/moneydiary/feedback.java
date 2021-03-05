package com.madassignment.moneydiary;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class feedback extends AppCompatActivity {
    TextView feedback_rating_text;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedback_rating_text = findViewById(R.id.feedback_rating_text);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0)
                {
                    feedback_rating_text.setText("Very Bad");
                }
                else if(rating == 1)
                {
                    feedback_rating_text.setText("Bad");
                }
                else if(rating == 2 || rating ==3)
                {
                    feedback_rating_text.setText("Average");
                }
                else if(rating == 4)
                {
                    feedback_rating_text.setText("Satisfied");
                }
                else if(rating == 5)
                {
                    feedback_rating_text.setText("Very Satisfied");
                }

            }
        });
    }
}