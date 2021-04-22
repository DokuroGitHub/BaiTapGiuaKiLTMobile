package com.example.notemanagementsystem.Repository;

import android.app.Application;

import com.example.notemanagementsystem.Data.EditProfileDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.EditProfile;

public class EditProfileRepository {
    private EditProfileDAO profileDAO;
    NoteManagementDatabase db;

    public EditProfileRepository (Application application) {
        db = NoteManagementDatabase.getInstance(application);
        profileDAO = db.getProfileDAO();
    }

    public void updateProfile (final EditProfile profile){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            profileDAO.update(profile);
        });
    }

    public void insertProfile (final EditProfile profile){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            profileDAO.insert(profile);
        });
    }
}
