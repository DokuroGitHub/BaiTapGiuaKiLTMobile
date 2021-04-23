package com.example.notemanagementsystem.ui.status;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.Repository.StatusRepository;


import java.util.List;

public class StatusViewModel extends AndroidViewModel {
    private static StatusRepository statusRepository;
    LiveData<List<Status>> mListStatus;

    public StatusViewModel(@NonNull Application application){
        super(application);
        statusRepository = new StatusRepository(application);
        mListStatus = statusRepository.getListStatus();
    }

    public LiveData<List<Status>> getListStatus(){
        return statusRepository.getListStatus();
    }

    public List<Status> getListStatusDF(){
        return statusRepository.getListStatusDF();
    }

    public void insertStatus(Status status){
        statusRepository.insertStatus(status);
    }

    public static void updateStatus(Status status){
        statusRepository.updateStatus(status);
    }

    public void deleteStatus(Status status){
        statusRepository.deleteStatus(status);
    }

}