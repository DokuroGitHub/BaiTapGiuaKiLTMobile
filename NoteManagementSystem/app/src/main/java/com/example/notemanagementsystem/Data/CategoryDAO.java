package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.NoteAndMenu;
import com.example.notemanagementsystem.Model.User;


import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getListCategory();

    @Query("SELECT * FROM Category")
    List<Category> getListCategories();

}
