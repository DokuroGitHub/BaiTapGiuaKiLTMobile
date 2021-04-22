package com.example.notemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test123
        //SignUp Account
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

        //SignIn Account
        userDAO = NoteManagementDatabase.getInstance(this).getUserDAO();
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignIn =(Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                User user = userDAO.getUser(email,password);
                if(user!= null){
                    Intent intent = new Intent(v.getContext(),DashboardActivity.class);
                    intent.putExtra("UserRepository",user);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"Email or Password incorrect, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

