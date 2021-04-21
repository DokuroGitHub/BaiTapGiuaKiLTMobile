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

    public PriorityRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        priorityDAO = db.getPriorityDAO();
        mListPriority = priorityDAO.getListPriority();
    }

    public LiveData<List<Priority>> getListPriority() {
        return priorityDAO.getListPriority();
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
