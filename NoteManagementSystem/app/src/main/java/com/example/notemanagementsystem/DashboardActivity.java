package com.example.notemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.notemanagementsystem.Model.User;

public class DashboardActivity extends AppCompatActivity {
    private User user;
    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        user = (User) getIntent().getSerializableExtra("User");
        tvUser = (TextView)findViewById(R.id.tvUser);

        if(user != null){
            tvUser.setText("Welcome"+user.getEmail());
        }


    }
}