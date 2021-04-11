package com.example.notemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassword, edtConfirmPassword;
    private Button btnSignIn,btnSignUp;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtConfirmPassword = (EditText) findViewById(R.id.edtConfirmPassword);
        db = new DBHelper(this);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

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
                        Boolean checkEmail = db.checkEmail(email);
                        if(checkEmail == false){
                            Boolean insertData = db.insertData(email,password);
                            if(insertData == true){
                                Toast.makeText(SignUpActivity.this,"Register successfully",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(SignUpActivity.this,"Register failed",Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUpActivity.this,"User already exist",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this,"Password not matching",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}