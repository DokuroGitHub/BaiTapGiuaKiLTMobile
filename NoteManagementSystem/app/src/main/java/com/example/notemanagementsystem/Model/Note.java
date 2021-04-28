package com.example.notemanagementsystem.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userID",
        onDelete = ForeignKey.CASCADE)})
public class Note implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String noteName;
    private String categoryName;
    private String priorityName;
    private String statusName;
    private String plantDate;
    private String currentDate;
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Note(String noteName, String categoryName, String priorityName, String statusName, String plantDate, String currentDate, int userID) {
        this.noteName = noteName;
        this.categoryName = categoryName;
        this.priorityName = priorityName;
        this.statusName = statusName;
        this.plantDate = plantDate;
        this.currentDate = currentDate;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
