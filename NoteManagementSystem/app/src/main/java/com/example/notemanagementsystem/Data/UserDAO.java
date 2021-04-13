package com.example.notemanagementsystem.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notemanagementsystem.Model.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User WHERE email = :email and password = :password")
    User getUser(String email, String password);

    @Insert
    void insert(User user);
}
