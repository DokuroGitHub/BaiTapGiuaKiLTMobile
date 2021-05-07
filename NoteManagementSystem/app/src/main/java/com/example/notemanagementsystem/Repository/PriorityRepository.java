package com.example.notemanagementsystem.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.PriorityDAO;
import com.example.notemanagementsystem.Model.Priority;

import java.util.List;

public class PriorityRepository {
    private PriorityDAO priorityDAO;
    NoteManagementDatabase db;
    private LiveData<List<Priority>> mListPriority;
    private int userID;

    public PriorityRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        priorityDAO = db.getPriorityDAO();
        mListPriority = priorityDAO.getListPriority(userID);
    }

    public LiveData<List<Priority>> getListPriority(final int userID) {
        return priorityDAO.getListPriority(userID);
    }

    public List<Priority> getListPriorityDF(final int userID) {
        return priorityDAO.getListPriorityDF(userID);
    }

    public void insertPriority(final Priority priority){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            priorityDAO.insert(priority);
        });
    }

    public void updatePriority(final Priority priority){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            priorityDAO.update(priority);
        });
    }

    public void deletePriority(final Priority priority){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            priorityDAO.delete(priority);
        });
    }
}
