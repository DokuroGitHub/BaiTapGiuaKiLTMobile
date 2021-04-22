package com.example.notemanagementsystem.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notemanagementsystem.Model.EditProfile;

@Dao
public interface EditProfileDAO {
    @Query("SELECT * FROM EditProfile WHERE firstName = :firstName and lastName = :lastName and email =:email")
    EditProfile getEditProfile(String firstName, String lastName, String email);

    @Insert
    void insert(EditProfile profile);

    @Update
    void update(EditProfile profile);
}
