package com.example.easyschedulemob.ui.home.locatario;

import android.os.Bundle;

import com.example.easyschedulemob.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.easyschedulemob.databinding.ActivityLocatarioBinding;

public class LocatarioActivity extends AppCompatActivity {

    private ActivityLocatarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocatarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_locatario, R.id.navigation_locacoes_locatario, R.id.navigation_notifications_locatario)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_locatario);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}