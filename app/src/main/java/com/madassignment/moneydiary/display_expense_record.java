package com.madassignment.moneydiary;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class display_expense_record extends AppCompatActivity {
    ContentValues value = new ContentValues();
    ListView lv;
    String description[];
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_scrolling);
        lv = (ListView) findViewById(R.id.expense_list);
        db.openOrCreateDatabase("Expense_database.db", null, null);

        Cursor c = db.query("expense_records", null, null, null,
                null,null, null);

        description = new String[c.getCount()];

        c.moveToFirst();

        for (int i = 0;i < description.length; i++) {
            description[i] = c.getString(3);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), description[position] + "\n", R.id.expense_list);
            }
        });
    }
}
