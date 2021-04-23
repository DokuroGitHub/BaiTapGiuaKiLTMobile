package com.example.notemanagementsystem.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User WHERE email = :email and password = :password")
    User getUser(String email, String password);

    //
    @Query("SELECT * FROM User WHERE email = :email")
    User getUserWithOutPass(String email);
    //

    @Insert
    void insert(User user);

    @Update
    void update(User user);

}
