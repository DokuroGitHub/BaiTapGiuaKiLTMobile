package com.example.notemanagementsystem.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userID",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Category.class,
                parentColumns = "id",
                childColumns = "categoryID",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Priority.class,
                parentColumns = "id",
                childColumns = "priorityID",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Status.class,
                parentColumns = "id",
                childColumns = "statusID",
                onDelete = ForeignKey.CASCADE),
})
public class Note implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String noteName;
    private int categoryID;
    private int priorityID;
    private int statusID;
    private String plantDate;
    private String currentDate;
    private int userID;

    public Note(String noteName, int categoryID, int priorityID, int statusID, String plantDate, String currentDate, int userID) {
        this.noteName = noteName;
        this.categoryID = categoryID;
        this.priorityID = priorityID;
        this.statusID = statusID;
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(int priorityID) {
        this.priorityID = priorityID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
