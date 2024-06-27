package com.example.easyschedulev20.view.locatario;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.easyschedulev20.R;
import com.example.easyschedulev20.databinding.ActivityLocatarioBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LocatarioActivity extends AppCompatActivity {

    private ActivityLocatarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocatarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Configurando o NavController e o AppBarConfiguration
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_locatario);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_quadras_locatario,
                R.id.navigation_locacao_quadra_locatario,
                R.id.navigation_notifications_locatario)
                .build();

        // Vinculando o NavController ao BottomNavigationView
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}

