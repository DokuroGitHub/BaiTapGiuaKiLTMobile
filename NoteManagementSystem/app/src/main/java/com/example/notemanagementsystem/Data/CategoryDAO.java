package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notemanagementsystem.Model.Category;


import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert
    void insert(Category category);

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getListCategory();
}