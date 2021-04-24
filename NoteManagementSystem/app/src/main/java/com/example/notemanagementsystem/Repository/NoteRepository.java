package com.example.notemanagementsystem.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Data.NoteDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Note;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    NoteManagementDatabase db;
    private LiveData<List<Note>> mListNote;


    public NoteRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        noteDAO = db.getNoteDAO();
        mListNote = noteDAO.getListNote();
//        mListStatus = statusDAO.getListStatus();
    }
    public LiveData<List<Note>> getListNote(){return noteDAO.getListNote();}
    public void insertNote (final Note note){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            noteDAO.insert(note);
        });
    }

    public void updateNote (final Note note){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            noteDAO.update(note);
        });
    }
}
