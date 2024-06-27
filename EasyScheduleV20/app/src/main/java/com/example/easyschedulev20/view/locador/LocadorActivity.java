package com.example.easyschedulev20.view.locador;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.easyschedulev20.R;
import com.example.easyschedulev20.databinding.ActivityLocadorBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LocadorActivity extends AppCompatActivity {

    private ActivityLocadorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocadorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_locador, R.id.navigation_locacao_quadra_locador, R.id.navigation_notifications_locador)
                .build();
        navView.inflateMenu(R.menu.bottom_nav_menu_locador);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_locador);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
}
