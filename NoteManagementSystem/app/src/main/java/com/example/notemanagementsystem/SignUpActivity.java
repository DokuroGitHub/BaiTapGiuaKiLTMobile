package com.example.notemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.UserDAO;
import com.example.notemanagementsystem.Model.User;

public class SignUpActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassword, edtConfirmPassword;
    private Button btnSignIn,btnSignUp;
    private UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtConfirmPassword = (EditText) findViewById(R.id.edtConfirmPassword);


        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        userDAO = NoteManagementDatabase.getInstance(this).getUserDAO();
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String rePassword = edtConfirmPassword.getText().toString();

                if(email.equals("")||password.equals("")|rePassword.equals(""))
                    Toast.makeText(SignUpActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    if(password.equals(rePassword)){
                        User user = new User(email,password);
                        userDAO.insert(user);
                        Toast.makeText(SignUpActivity.this,"Create account successfully",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this,"Password not matching",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}