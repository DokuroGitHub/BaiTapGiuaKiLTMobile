package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.Status;


import java.util.List;

@Dao
public interface StatusDAO {
    @Query("SELECT * FROM Status")
    List<Status> getListStatusDF();

    @Insert
    void insert(Status status);

    @Update
    void update(Status status);

    @Delete
    void delete(Status status);

    @Query("SELECT * FROM Status")
    LiveData<List<Status>> getListStatus();
}
