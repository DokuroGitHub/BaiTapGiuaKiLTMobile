package com.example.notemanagementsystem.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class EditProfile implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @Nullable
    private String firstName;
    @Nullable
    private String lastName;

    private String email;

    public EditProfile (String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  '\n' +
                "firstName=" + firstName + '\n' +
                "lastName=" + lastName + '\n' +
                "email=" + email;
    }
}
