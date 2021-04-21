package com.example.notemanagementsystem.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import java.io.Serializable;


@Entity
public class Status implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String statusName;
    private String createDate;

    //Constructor
    public Status(String statusName, String createDate) {
        this.statusName = statusName;
        this.createDate = createDate;
    }

    //Getter and Setter
    public int getId() {
        return id;
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
}

