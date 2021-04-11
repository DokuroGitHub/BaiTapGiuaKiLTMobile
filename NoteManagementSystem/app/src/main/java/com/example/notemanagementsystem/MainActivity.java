package com.example.notemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    //init
    private FloatingActionButton btnSignUp;
    private EditText edtEmail, edtPassword;
    private Button btnSignIn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        db = new DBHelper(this);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignIn =(Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if(email.equals("")||password.equals(""))
                    Toast.makeText(MainActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkUser = db.checkUser(email,password);
                    if(checkUser == true){
                        Toast.makeText(MainActivity.this,"Sign in successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(v.getContext(),DashboardActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this,"Email or password does not exist, please try again",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}