package com.example.easyschedulev20.view.locatario;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.os.Build;
import android.view.View;
import android.widget.Button;
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

        int userId = getIntent().getIntExtra("usuarioId", 0);


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

        // Passar o userId para o fragmento inicial
        Bundle bundle = new Bundle();
        bundle.putInt("usuarioId", userId);
        navController.navigate(R.id.navigation_quadras_locatario, bundle);

        Button notifyButton = findViewById(R.id.notify_button);
        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "locatario_channel_id";
            String channelName = "Locatario Channel";
            String channelDescription = "Channel for locatario notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            channel.setDescription(channelDescription);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "locatario_channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Locatário")
                .setContentText("Quadra locada")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        int notificationId = 1;
        notificationManager.notify(notificationId, builder.build());
    }

}

