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
public class Status implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String statusName;
    private String createDate;
    private int userID;

    //Constructor
    public Status(String statusName, String createDate, int userID) {
        this.statusName = statusName;
        this.createDate = createDate;
        this.userID = userID;
    }

    //Getter and Setter
    public int getId() {
        return id;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return  statusName ;
    }
}

