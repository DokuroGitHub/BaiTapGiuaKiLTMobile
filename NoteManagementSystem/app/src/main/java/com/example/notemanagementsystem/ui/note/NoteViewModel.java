package com.example.notemanagementsystem.ui.note;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.NoteAndMenu;
import com.example.notemanagementsystem.Repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    LiveData<List<Note>> mListNote;
    LiveData<List<NoteAndMenu>> mListNoteAndMenu;
    private int userID;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        mListNote = noteRepository.getListNote(userID);
    }

    public LiveData<List<Note>> getListNote(final int userID){
        return noteRepository.getListNote(userID);
    }

    public void insertNote (Note note){
        noteRepository.insertNote(note);
    }

    public void updateNote (Note note){
        noteRepository.updateNote(note);
    }

}