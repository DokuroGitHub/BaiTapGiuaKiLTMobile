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

    public PriorityModel(@NonNull Application application) {
        super(application);
        priorityRepository = new PriorityRepository(application);
        mListPriority = priorityRepository.getListPriority();
    }

    public LiveData<List<Priority>> getListPriority() {
        return priorityRepository.getListPriority();
    }

    public void insertPriority(Priority priority){
        priorityRepository.insertPriority(priority);
    }
}