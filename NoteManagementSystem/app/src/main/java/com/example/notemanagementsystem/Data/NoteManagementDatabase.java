package com.example.notemanagementsystem.Data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.User;

@androidx.room.Database(entities = {User.class, Category.class}, version = 1, exportSchema = false)
public abstract class NoteManagementDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "NoteManagement.db";
    public abstract UserDAO getUserDAO();
    public abstract CategoryDAO getCategoryDAO();
    private static NoteManagementDatabase instance;
    public static synchronized NoteManagementDatabase getInstance(Context context){
        if(instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteManagementDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }

}