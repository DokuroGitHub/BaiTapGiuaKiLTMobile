package com.example.notemanagementsystem.ui.account;

import android.accounts.Account;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.notemanagementsystem.DashboardActivity;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.UserDAO;
import com.example.notemanagementsystem.Model.User;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.category.CategoryModel;

import java.security.PublicKey;

public class ChangePasswordFragment extends Fragment {
    private Button btnHome,btnChangePassword;
    private EditText edt_currentPass,edt_newPass,edt_confirm;
    private AccountViewModel accountViewModel;
    private UserDAO userDAO;
    private User user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //take email
        DashboardActivity dashboardActivity = new DashboardActivity();
        DashboardActivity activity = (DashboardActivity)getActivity();
        Bundle results = activity.getMyData();
        String email = results.getString("val1");
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_change_password, container, false);
        //Home button
        btnHome = root.findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_changePassword_to_nav_home);
            }
        });
        //Change Password
        userDAO = NoteManagementDatabase.getInstance(getActivity()).getUserDAO();
        edt_currentPass = root.findViewById(R.id.edt_currentPass);
        edt_newPass = root.findViewById(R.id.edt_newPass);
        edt_confirm = root.findViewById(R.id.edt_confirm);
        btnChangePassword =root.findViewById(R.id.btnChangePassword);
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = edt_currentPass.getText().toString().trim();
                String newPassword = edt_newPass.getText().toString().trim();
                String repeatPassword = edt_confirm.getText().toString().trim();
                User checkPass = userDAO.getUser(email, oldPassword);
                if (oldPassword.equals("") || newPassword.equals("") | repeatPassword.equals(""))
                    Toast.makeText(v.getContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if(checkPass != null){
                        if(newPassword.equals(repeatPassword)) {
                            accountViewModel = new ViewModelProvider(getActivity()).get(AccountViewModel.class);
                            user = userDAO.getUser(email,oldPassword);
                            user.setPassword(newPassword);
                            accountViewModel.updateUser(user);
                            Toast.makeText(v.getContext(),"Update password successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(v.getContext(),"Password does not match",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(v.getContext(),"Current password incorrectly",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    private void update(){

    }




}