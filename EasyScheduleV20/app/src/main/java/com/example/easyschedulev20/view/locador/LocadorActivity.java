package com.example.easyschedulev20.view.locador;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import com.example.easyschedulev20.model.Notificacao;
import com.example.easyschedulev20.model.Repository.NotificacaoRepository;

public class LocadorActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private ActivityLocadorBinding binding;
    private NotificacaoRepository notificacaoRepository;
    private int userId;
    private  int idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocadorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notificacaoRepository = new NotificacaoRepository(getApplication());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_locador, R.id.navigation_locacao_quadra_locador, R.id.navigation_notifications_locador)
                .build();
        navView.inflateMenu(R.menu.bottom_nav_menu_locador);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_locador);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        userId = getIntent().getIntExtra("userId", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("userId", userId);
        navController.navigate(R.id.navigation_locador, bundle);

        createNotificationChannel();

        Button notifyButton = findViewById(R.id.notify_button);
        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(LocadorActivity.this, Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(LocadorActivity.this,
                            new String[]{Manifest.permission.POST_NOTIFICATIONS}, PERMISSION_REQUEST_CODE);
                } else {
                    sendNotificationAndSaveToDatabase();
                }
            }
        });

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

    @SuppressLint("MissingPermission")
    private void sendNotificationAndSaveToDatabase() {

        createNotificationChannel();

        Notificacao notificacao = new Notificacao("Locador", "Quadra adicionada", "locador", userId);
        notificacaoRepository.insert(notificacao);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "locador_channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Locador")
                .setContentText("Quadra adicionada")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        int notificationId = 1;
        notificationManager.notify(notificationId, builder.build());
    }
    private int getCurrentUserId() {
        return userId;
    }
}
