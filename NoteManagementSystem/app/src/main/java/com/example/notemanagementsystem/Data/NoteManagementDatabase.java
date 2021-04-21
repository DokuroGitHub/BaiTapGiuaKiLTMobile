package com.example.notemanagementsystem.Data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.Model.User;

<<<<<<< Updated upstream
@androidx.room.Database(entities = {User.class, Category.class}, version = 1, exportSchema = false)
=======
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {User.class, Category.class, Status.class}, version = 1, exportSchema = false)
>>>>>>> Stashed changes
public abstract class NoteManagementDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "NoteManagement.db";
    public abstract UserDAO getUserDAO();
    public abstract CategoryDAO getCategoryDAO();
    public abstract StatusDAO getStatusDAO();
    private static NoteManagementDatabase instance;
<<<<<<< Updated upstream
=======
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

>>>>>>> Stashed changes
    public static synchronized NoteManagementDatabase getInstance(Context context){
        if(instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteManagementDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }

}
