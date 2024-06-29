package com.example.easyschedulev20.view.locador;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
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

        int userId = getIntent().getIntExtra("usuarioId", 0);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_locador, R.id.navigation_locacao_quadra_locador, R.id.navigation_notifications_locador)
                .build();
        navView.inflateMenu(R.menu.bottom_nav_menu_locador);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_locador);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        createNotificationChannel();

        Button notifyButton = findViewById(R.id.notify_button);
        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });

        Bundle bundle = new Bundle();
        bundle.putInt("usuarioId", userId);
        navController.navigate(R.id.navigation_locador, bundle);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "locador_channel_id";
            String channelName = "Locador Channel";
            String channelDescription = "Channel for locador notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            channel.setDescription(channelDescription);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "locador_channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Locador")
                .setContentText("Quadra adicionada")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        int notificationId = 1;
        notificationManager.notify(notificationId, builder.build());
    }
}
