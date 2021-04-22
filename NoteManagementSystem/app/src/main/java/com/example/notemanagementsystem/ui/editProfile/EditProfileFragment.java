package com.example.notemanagementsystem.ui.editProfile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notemanagementsystem.DashboardActivity;
import com.example.notemanagementsystem.Data.EditProfileDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.EditProfile;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.account.AccountViewModel;

public class EditProfileFragment extends Fragment {
    private Button btnHome, btnEditProfile;
    private EditText edt_firstName, edt_lastName, edt_email;
    private EditViewModel editViewModel;
    private EditProfileDAO profileDAO;
    private EditProfile profile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        editViewModel = new ViewModelProvider(this).get(EditViewModel.class);
        View root = inflater.inflate(R.layout.fragment_editprofile, container, false);
        //Home button
        btnHome = root.findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_editprofile_to_nav_home);
            }
        });
        // Change first name
        profileDAO = NoteManagementDatabase.getInstance(getActivity()).getProfileDAO();
        edt_firstName = root.findViewById(R.id.edt_firstName);
        edt_lastName = root.findViewById(R.id.edt_lastName);
        edt_email = root.findViewById(R.id.edt_email);
        btnEditProfile = root.findViewById(R.id.btnEditProfile);
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFirstName = edt_firstName.getText().toString().trim();
                String newLastName = edt_lastName.getText().toString().trim();
                String newEmail = edt_email.getText().toString().trim();

                if (newFirstName.equals("") || newLastName.equals("") | newEmail.equals(""))
                    Toast.makeText(v.getContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if(profile == null){
                        EditProfile profile = new EditProfile(newFirstName, newLastName, newEmail);
                        editViewModel.insertProfile(profile);
                        Toast.makeText(v.getContext(),"Insert profile successfully",Toast.LENGTH_SHORT).show();
                    }
                    else
                        editViewModel = new ViewModelProvider(getActivity()).get(EditViewModel.class);
                        profile = profileDAO.getEditProfile(newFirstName, newLastName, newEmail);
                        profile.setFirstName(newFirstName);
                        profile.setLastName(newLastName);
                        profile.setEmail(newEmail);
                        editViewModel.updateProfile(profile);
                        Toast.makeText(v.getContext(),"Update profile successfully" + profile.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}