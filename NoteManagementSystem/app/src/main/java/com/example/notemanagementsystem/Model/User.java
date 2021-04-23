package com.example.notemanagementsystem.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @NonNull
    private String email;
    @NonNull
    private String password;
    // now
    @Nullable
    private String lname;
    @NonNull
    private String fname;

    public User(String email, String password, String lname, String fname) {
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // now
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return
                "Id: " + id + "\n" +
                "Email: " + email + '\n' +
                "Password= " + password + '\n' +
                "LastName= " + lname + '\n' +
                "FirstName= " + fname;
    }
}
