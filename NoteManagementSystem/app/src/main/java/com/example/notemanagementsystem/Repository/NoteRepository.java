package com.example.notemanagementsystem.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Data.EditProfileDAO;
import com.example.notemanagementsystem.Data.NoteDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.EditProfile;
import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.NoteAndMenu;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    NoteManagementDatabase db;
    private LiveData<List<Note>> mListNote;
    private LiveData<List<NoteAndMenu>> mListNoteAndMenu;


    public NoteRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        noteDAO = db.getNoteDAO();
        mListNote = noteDAO.getListNote();
        mListNoteAndMenu = noteDAO.getListNoteName();
//        mListStatus = statusDAO.getListStatus();
    }
    public LiveData<List<Note>> getListNote(){return noteDAO.getListNote();}
    public LiveData<List<NoteAndMenu>> getListNoteName(){return noteDAO.getListNoteName();}
    public void insertNote (final Note note){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            noteDAO.insert(note);
        });
    }
}
