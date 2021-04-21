package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.User;


import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getListCategory();

    @Query("SELECT * FROM category WHERE categoryName = :categoryName and createDate = :createDate")
    User getCategoryName(String categoryName, String createDate);
}
