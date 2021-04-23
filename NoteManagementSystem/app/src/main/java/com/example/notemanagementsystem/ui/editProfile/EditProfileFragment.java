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
import com.example.notemanagementsystem.Data.UserDAO;
import com.example.notemanagementsystem.Model.EditProfile;
import com.example.notemanagementsystem.Model.User;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.account.AccountViewModel;

public class EditProfileFragment extends Fragment {
    private Button btnHome2, btnEditProfile;
    private EditText edt_firstName, edt_lastName, edt_email;
//    private EditViewModel editViewModel;
//    private EditProfileDAO profileDAO;
//    private EditProfile profile;
    private AccountViewModel accountViewModel;
    private UserDAO userDAO;
    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //editViewModel = new ViewModelProvider(this).get(EditViewModel.class);
        //take email
        DashboardActivity dashboardActivity = new DashboardActivity();
        DashboardActivity activity = (DashboardActivity)getActivity();
        Bundle results = activity.getMyData();
        String email = results.getString("val1");
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_editprofile, container, false);
        //Home button
        btnHome2 = root.findViewById(R.id.btnHome2);
        btnHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_editprofile_to_nav_home);
            }
        });
        // Change first name
        //profileDAO = NoteManagementDatabase.getInstance(getActivity()).getProfileDAO();
        userDAO = NoteManagementDatabase.getInstance(getActivity()).getUserDAO();
        edt_firstName = root.findViewById(R.id.edt_firstName);
        edt_lastName = root.findViewById(R.id.edt_lastName);
        edt_email = root.findViewById(R.id.edt_email);
        edt_email.setText(email);
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
                    accountViewModel = new ViewModelProvider(getActivity()).get(AccountViewModel.class);
                    user = userDAO.getUserWithOutPass(email);
                    int x = 1; // breakpoin
                    user.setFname(newFirstName);
                    user.setLname(newLastName);
                    user.setEmail(newEmail);
                    accountViewModel.updateUser(user);
                    Toast.makeText(v.getContext(),"Update password successfully" + user.toString(),Toast.LENGTH_SHORT).show();
//                    if(profile == null){
//                        EditProfile profile = new EditProfile(newFirstName, newLastName, newEmail);
//                        editViewModel.insertProfile(profile);
//                        Toast.makeText(v.getContext(),"Insert profile successfully",Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                        editViewModel = new ViewModelProvider(getActivity()).get(EditViewModel.class);
//                        profile = profileDAO.getEditProfile(newFirstName, newLastName, newEmail);
//                        profile.setFirstName(newFirstName);
//                        profile.setLastName(newLastName);
//                        profile.setEmail(newEmail);
//                        editViewModel.updateProfile(profile);
//                        Toast.makeText(v.getContext(),"Update profile successfully" + profile.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    private void update(){

    }
}