package com.example.notemanagementsystem.ui.note;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notemanagementsystem.Model.EditProfile;
import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.NoteAndMenu;
import com.example.notemanagementsystem.Repository.EditProfileRepository;
import com.example.notemanagementsystem.Repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    LiveData<List<Note>> mListNote;
    LiveData<List<NoteAndMenu>> mListNoteAndMenu;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        mListNote = noteRepository.getListNote();
        mListNoteAndMenu = noteRepository.getListNoteName();
    }

    public LiveData<List<Note>> getListNote(){
        return noteRepository.getListNote();
    }

    public LiveData<List<NoteAndMenu>> getListNoteName(){
        return noteRepository.getListNoteName();
    }

    public void insertNote (Note note){
        noteRepository.insertNote(note);
    }

}