package com.example.notemanagementsystem.Model;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

;

public class Category implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private Date createDate;

    public Category(String name, Date createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
