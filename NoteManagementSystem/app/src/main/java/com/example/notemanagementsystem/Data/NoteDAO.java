package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.NoteAndMenu;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getListNote();

    @Query("SELECT  COUNT(*) FROM Note GROUP BY statusName;")
    int [] getPercent();

    @Transaction
    @Query("SELECT * FROM Category")
    LiveData<List<NoteAndMenu>> getCategoryAndNote();



}
