package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notemanagementsystem.Model.Priority;

import java.util.List;

@Dao
public interface PriorityDAO {
    @Insert
    void insert(Priority priority);

    @Query("SELECT * FROM Priority")
    LiveData<List<Priority>> getListPriority();
}
