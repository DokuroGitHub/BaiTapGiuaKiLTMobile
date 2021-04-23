package com.example.notemanagementsystem.Model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class NoteAndMenu {
    private String noteName;
    private String categoryName;
    private String priorityName;
    private String statusName;
    private String plantDate;
    private String currentDate;

    public NoteAndMenu(String noteName, String categoryName, String priorityName, String statusName, String plantDate, String currentDate) {
        this.noteName = noteName;
        this.categoryName = categoryName;
        this.priorityName = priorityName;
        this.statusName = statusName;
        this.plantDate = plantDate;
        this.currentDate = currentDate;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(String plantDate) {
        this.plantDate = plantDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}
