package com.madassignment.moneydiary.HelperClasses;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class phonehelper {

    int image;
    String title;
    String id;
    GradientDrawable color;

    public phonehelper(GradientDrawable color, int image, String title, String id) {
        this.image = image;
        this.title = title;
        this.color = color;
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getId() { return id; }

    public Drawable getgradient() {
        return color;
    }


}
