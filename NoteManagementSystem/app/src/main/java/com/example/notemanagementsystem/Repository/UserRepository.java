package com.example.notemanagementsystem.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.PriorityDAO;
import com.example.notemanagementsystem.Data.UserDAO;
import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.Model.User;

import java.util.List;

public class UserRepository {
    private UserDAO userDAO;
    NoteManagementDatabase db;

    public UserRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        userDAO = db.getUserDAO();
    }

    public void updateUser(final User user){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.update(user);
        });
    }
}
