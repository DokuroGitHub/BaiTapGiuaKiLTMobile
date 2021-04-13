package com.example.notemanagementsystem.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.notemanagementsystem.Model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO getUserDAO();
}
