package com.example.notemanagementsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.NoteAndMenu;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert
    void insert(Note note);

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getListNote();

    @Transaction
    @Query("SELECT * FROM Category")
    LiveData<List<NoteAndMenu>> getCategoryAndNote();

    @Query("SELECT noteName, Category.categoryName, Priority.priorityName, Status.statusName, plantDate, currentDate FROM Note,Category,Priority,Status WHERE Note.categoryID == Category.id AND Note.priorityID == Priority.id AND Status.id == Note.statusID")
    LiveData<List<NoteAndMenu>> getListNoteName();

}
