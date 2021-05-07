package com.example.notemanagementsystem.ui.priority;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.Repository.PriorityRepository;

import java.util.List;

public class PriorityModel extends AndroidViewModel {
    private PriorityRepository priorityRepository;
    LiveData<List<Priority>> mListPriority;
    private int userID;

    public PriorityModel(@NonNull Application application) {
        super(application);
        priorityRepository = new PriorityRepository(application);
        mListPriority = priorityRepository.getListPriority(userID);
    }

    public LiveData<List<Priority>> getListPriority(final int userID) {
        return priorityRepository.getListPriority(userID);
    }

    public List<Priority> getListPriorityDF(final int userID) {
        return priorityRepository.getListPriorityDF(userID);
    }

    public void insertPriority(Priority priority){
        priorityRepository.insertPriority(priority);
    }

    public void updatePriority(Priority priority){
        priorityRepository.updatePriority(priority);
    }

    public void deletePriority(Priority priority) {
        priorityRepository.deletePriority(priority);
    }
}