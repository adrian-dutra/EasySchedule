package com.example.easyschedulev20.view.locatario;


import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import com.example.easyschedulev20.view.locador.LocadorActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.easyschedulev20.model.Notificacao;
import com.example.easyschedulev20.model.Repository.NotificacaoRepository;
import com.example.easyschedulev20.model.Usuario;

public class LocatarioActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private ActivityLocatarioBinding binding;
    private NotificacaoRepository notificacaoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocatarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notificacaoRepository = new NotificacaoRepository(getApplication());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_locatario);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_quadras_locatario,
                R.id.navigation_locacao_quadra_locatario,
                R.id.navigation_notifications_locatario)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Button notifyButton = findViewById(R.id.notify_button);
        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(LocatarioActivity.this, android.Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(LocatarioActivity.this,
                            new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, PERMISSION_REQUEST_CODE);
                } else {
                    sendNotificationAndSaveToDatabase();
                }
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

    @SuppressLint("MissingPermission")
    private void sendNotificationAndSaveToDatabase() {
        createNotificationChannel();
        int userId = getCurrentUserId();

        Notificacao notificacao = new Notificacao("Locatário", "Quadra locada", "locatario", userId );
        notificacaoRepository.insert(notificacao);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "locatario_channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Locatário")
                .setContentText("Quadra locada")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        int notificationId = 1;
        notificationManager.notify(notificationId, builder.build());

    }

    private int getCurrentUserId() {
        LocatarioActivity userViewModel = this;
        return userViewModel.getCurrentUserId();
    }

}

