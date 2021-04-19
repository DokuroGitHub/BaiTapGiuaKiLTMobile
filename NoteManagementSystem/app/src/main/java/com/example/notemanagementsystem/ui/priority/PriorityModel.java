package com.example.notemanagementsystem.ui.priority;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PriorityModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PriorityModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is priority fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}