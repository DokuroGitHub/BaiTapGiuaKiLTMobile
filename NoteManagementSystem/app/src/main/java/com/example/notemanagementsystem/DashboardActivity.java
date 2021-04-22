package com.example.notemanagementsystem;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.notemanagementsystem.Model.EditProfile;
import com.example.notemanagementsystem.Model.User;
import com.example.notemanagementsystem.ui.account.ChangePasswordFragment;
import com.example.notemanagementsystem.ui.editProfile.EditProfileFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity {
    private User user;
    private TextView txtUser;
    private EditProfile profile;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_category, R.id.nav_priority, R.id.nav_status, R.id.nav_note, R.id.nav_changePassword, R.id.nav_editProfile)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        user = (User)getIntent().getSerializableExtra("UserRepository");
        txtUser = (TextView)findViewById(R.id.txtUser);
        if (user != null)
            txtUser.setText(user.getEmail());
        //send data to fragment
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        EditProfileFragment pfm = new EditProfileFragment();
        pfm.setArguments(bundle);
        bundle.putString("email",user.getEmail());
        ChangePasswordFragment fragment = new ChangePasswordFragment();
        fragment.setArguments(bundle);
        return true;
    }

    public Bundle getMyData() {
        user = (User)getIntent().getSerializableExtra("UserRepository");
        txtUser = (TextView)findViewById(R.id.txtUser);
        if (user != null)
            txtUser.setText(user.getEmail());
        //send data to fragment
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        Bundle hm = new Bundle();
        hm.putString("val1",user.getEmail());
        return hm;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}