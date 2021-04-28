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
public class Priority implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String priorityName;
    private String create_priority_Date;
    private int userID;

    public Priority(String priorityName, String create_priority_Date, int userID){
        this.priorityName = priorityName;
        this.create_priority_Date = create_priority_Date;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getCreate_priority_Date() {
        return create_priority_Date;
    }

    public void setCreate_priority_Date(String create_priority_Date) {
        this.create_priority_Date = create_priority_Date;
    }

    @Override
    public String toString() {
        return priorityName ;
    }
}
