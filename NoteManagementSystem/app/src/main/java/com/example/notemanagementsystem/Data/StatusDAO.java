package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.Category;
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

    @Query("SELECT * FROM Status where userID = :userID")
    LiveData<List<Status>> getListStatus(int userID);

    @Query("SELECT * FROM status WHERE statusName= :statusName AND userID= :userID ")
    List<Status> checkStatus(String statusName, int userID);
}
