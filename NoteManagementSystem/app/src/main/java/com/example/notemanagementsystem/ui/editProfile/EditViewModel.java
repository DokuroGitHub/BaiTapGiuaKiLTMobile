package com.example.notemanagementsystem.ui.editProfile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.notemanagementsystem.Model.EditProfile;
import com.example.notemanagementsystem.Repository.EditProfileRepository;

public class EditViewModel extends AndroidViewModel {
    private EditProfileRepository profileRepository;

    public EditViewModel(@NonNull Application application) {
        super(application);
        profileRepository = new EditProfileRepository(application);
    }

    public void insertProfile (EditProfile profile){
        profileRepository.insertProfile(profile);
    }

    public void updateProfile (EditProfile profile){
        profileRepository.updateProfile(profile);
    }
}
