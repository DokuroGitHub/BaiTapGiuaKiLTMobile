package com.example.notemanagementsystem.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.io.Serializable;
import java.util.Date;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userID",
        onDelete = ForeignKey.CASCADE)})
public class Category implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String categoryName;
    private String createDate;
    private int userID;

    public Category(String categoryName, String createDate, int userID) {
        this.categoryName = categoryName;
        this.createDate = createDate;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return  categoryName ;
    }
}

