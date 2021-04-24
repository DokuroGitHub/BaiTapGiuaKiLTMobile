package com.example.notemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.UserDAO;
import com.example.notemanagementsystem.Model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    //init
    private FloatingActionButton btnSignUp;
    private EditText edtEmail, edtPassword;
    private Button btnSignIn;
    UserDAO userDAO;
    private CheckBox mCheckBoxRemember;
    private SharedPreferences mPrefs;
    private static final String PREFS_NAME = "PrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //remember set
        mPrefs = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        mCheckBoxRemember = (CheckBox)findViewById(R.id.chkRemember);
        //SignUp Account
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

        /**
         * Sign in or Sign up
         * Set Remember username
         * */
        userDAO = NoteManagementDatabase.getInstance(this).getUserDAO();
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        getPreferencesData();
        btnSignIn =(Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                User user = userDAO.getUser(email,password);
                //Remember email
                if(mCheckBoxRemember.isChecked()){
                    Boolean boolIsChecked = mCheckBoxRemember.isChecked();
                    SharedPreferences.Editor editor = mPrefs.edit();
                    editor.putString("pref_email",email);
                    editor.putString("pref_pass",password);
                    editor.putBoolean("pref_check",boolIsChecked);
                    editor.apply();
                    Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_SHORT).show();
                }else {
                    mPrefs.edit().clear().apply();
                }
                if(user!= null){
                    Intent intent = new Intent(v.getContext(),DashboardActivity.class);
                    intent.putExtra("UserRepository",user);
                    startActivity(intent);
                    edtEmail.getText().clear();
                    edtPassword.getText().clear();
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"Email or Password incorrect, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getPreferencesData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        if(sp.contains("pref_email")){
            String u = sp.getString("pref_email","not found.");
            edtEmail.setText(u.toString());
        }
        if(sp.contains("pref_check")){
            Boolean b = sp.getBoolean("pref_check",false);
            mCheckBoxRemember.setChecked(b);
        }
    }
}

