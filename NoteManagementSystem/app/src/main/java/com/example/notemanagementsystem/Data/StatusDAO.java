package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notemanagementsystem.Model.Status;


import java.util.List;

@Dao
public interface StatusDAO {
    @Insert
    void insert(Status category);

    @Query("SELECT * FROM Status")
    LiveData<List<Status>> getListStatus();
}
