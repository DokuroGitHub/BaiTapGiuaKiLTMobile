package com.example.notemanagementsystem.Data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.EditProfile;
import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.Model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {User.class, Category.class, Priority.class, Status.class, EditProfile.class}, version = 1, exportSchema = false)

public abstract class NoteManagementDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "NoteManagement.db";
    public abstract UserDAO getUserDAO();
    public abstract CategoryDAO getCategoryDAO();
    public abstract PriorityDAO getPriorityDAO();
    public abstract EditProfileDAO getProfileDAO();
    public abstract StatusDAO getStatusDAO();
    private static NoteManagementDatabase instance;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized NoteManagementDatabase getInstance(Context context){
        if(instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteManagementDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }

}
