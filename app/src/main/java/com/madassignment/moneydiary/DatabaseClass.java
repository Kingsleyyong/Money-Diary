package com.madassignment.moneydiary;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.madassignment.moneydiary.EntityClass.Budgets;
import com.madassignment.moneydiary.EntityClass.Goals;
import com.madassignment.moneydiary.EntityClass.User;
import com.madassignment.moneydiary.EntityClass.Expense;
import com.madassignment.moneydiary.EntityClass.bill;
import com.madassignment.moneydiary.EntityClass.income;
import com.madassignment.moneydiary.EntityClass.wallet;

@Database(entities = {User.class, wallet.class, bill.class, income.class, Expense.class, Budgets.class, Goals.class},version = 1)
public abstract class DatabaseClass extends RoomDatabase {
    private static DatabaseClass instance;

    static DatabaseClass getDatabase(final Context context)
    {
        if(instance ==null)
        {
            //create a database name MoneyDiary if there does not have any database
            synchronized (DatabaseClass.class)
            {
                instance = Room.databaseBuilder(context,DatabaseClass.class,"MoneyDiary").build();
            }
        }
        return instance;
    }

}
