package com.example.notemanagementsystem.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.StatusDAO;
import com.example.notemanagementsystem.Model.Status;

import java.util.List;

public class StatusRepository {
    private StatusDAO statusDAO;
    NoteManagementDatabase db;
    private LiveData<List<Status>> mListStatus;
    private int userID;

    public StatusRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        statusDAO = db.getStatusDAO();
        mListStatus = statusDAO.getListStatus(userID);
    }
    public LiveData<List<Status>> getListStatus(final int userID){
        return statusDAO.getListStatus(userID);
    }

    public void insertStatus(final Status status){
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            statusDAO.insert(status);
        });
    }

    public void updateStatus(final Status status) {
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            statusDAO.update(status);
        });
    }

    public void deleteStatus(final Status status) {
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            statusDAO.delete(status);
        });
    }

    public List<Status> getListStatusDF() {
        return statusDAO.getListStatusDF();
    }
}
