package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Priority;

import java.util.List;

@Dao
public interface PriorityDAO {
    @Insert
    void insert(Priority priority);

    @Update
    void update(Priority priority);

    @Delete
    void delete(Priority priority);

    @Query("SELECT * FROM Priority where userID = :userID")
    LiveData<List<Priority>> getListPriority(int userID);

    @Query("SELECT * FROM Priority WHERE userID = :userID ")
    List<Priority> getListPriorityDF(int userID);

    @Query("SELECT * FROM priority WHERE priorityName= :priorityName AND userID= :userID ")
    List<Priority> checkPriority(String priorityName, int userID);
}
