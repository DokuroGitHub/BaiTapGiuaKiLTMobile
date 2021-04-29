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

    @Query("SELECT * FROM Note where userID = :userID")
    LiveData<List<Note>> getListNote(int userID);

    @Query("SELECT categoryName From Category where id =:categoryID")
    public String getCategoryName(int categoryID);

    @Query("SELECT priorityName From Priority where id =:categoryID")
    public String getPriorityName(int categoryID);

    @Query("SELECT statusName From Status where id =:categoryID")
    public String getStatusName(int categoryID);

    @Query("SELECT  COUNT(*) FROM Note,Status where Note.userID = :userID and statusID = Status.id GROUP BY statusName")
    int [] getPercent(int userID);

    @Query("SELECT * FROM Category")
    public NoteAndMenu getCategoryAndNote();

    @Query("SELECT  statusName FROM Note,status where Note.userID =:userID and statusID = Status.id GROUP BY statusName")
    String[] getStatus(int userID);
}
