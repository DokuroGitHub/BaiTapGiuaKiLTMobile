package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.User;


import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert
    void insert(Category category);

<<<<<<< HEAD
    @Update
    void update(Category category);

<<<<<<< HEAD
    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getListCategory();

    @Query("SELECT * FROM category WHERE categoryName = :categoryName and createDate = :createDate")
    User getCategoryName(String categoryName, String createDate);
=======
    @Delete
    void delete(Category category);

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getListCategory();


>>>>>>> Category
=======
    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getListCategory();
>>>>>>> parent of 6108fba (category( edit+delete))
}
