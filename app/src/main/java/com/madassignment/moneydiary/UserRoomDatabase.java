package com.madassignment.moneydiary;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)

public abstract class UserRoomDatabase extends RoomDatabase {
    private static final String dbname= "user";
    public abstract UserDao userDao();

    private static UserRoomDatabase INSTANCE;

    public static synchronized UserRoomDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class,
                            "user").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
