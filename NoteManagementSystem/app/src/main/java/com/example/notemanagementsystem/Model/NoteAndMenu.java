package com.example.notemanagementsystem.Model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class NoteAndMenu {

    @Embedded
    Category category;

    @Relation(parentColumn = "id", entityColumn = "categoryID", entity = Note.class)
    public List<Note> note;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }
}
