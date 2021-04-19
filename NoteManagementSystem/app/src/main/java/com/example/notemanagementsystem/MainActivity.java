package com.example.notemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notemanagementsystem.Data.UserDAO;
import com.example.notemanagementsystem.Data.UserDatabase;
import com.example.notemanagementsystem.Model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    //init
    private FloatingActionButton btnSignUp;
    private EditText edtEmail, edtPassword;
    private Button btnSignIn;
    UserDAO userDAO;
    UserDatabase db;

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
        db = Room.databaseBuilder(this,UserDatabase.class,"User")
                .allowMainThreadQueries()
                .build();
        userDAO = db.getUserDAO();
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
                    intent.putExtra("User",user);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"Email or Password incorrect, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
//
// user = (User) getIntent().getSerializableExtra("User");
//         tvUser = (TextView)findViewById(R.id.tvUser);
//
//         if(user != null){
//         tvUser.setText(user.getEmail());
//         }