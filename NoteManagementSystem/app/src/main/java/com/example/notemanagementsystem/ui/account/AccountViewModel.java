package com.example.notemanagementsystem.ui.account;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.User;
import com.example.notemanagementsystem.Repository.CategoryRepository;
import com.example.notemanagementsystem.Repository.UserRepository;

import java.util.List;

public class AccountViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public AccountViewModel(@NonNull Application application){
        super(application);
        userRepository = new UserRepository(application);
    }
    public void updateUser(User user){
        userRepository.updateUser(user);
    }
}