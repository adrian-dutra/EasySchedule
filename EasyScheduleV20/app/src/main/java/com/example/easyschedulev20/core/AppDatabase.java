package com.example.easyschedulev20.core;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import com.example.easyschedulev20.model.Converters;
import com.example.easyschedulev20.model.Dao.LocacaoQuadraDAO;
import com.example.easyschedulev20.model.Dao.NotificacaoDAO;
import com.example.easyschedulev20.model.Dao.QuadraEsportivaDAO;
import com.example.easyschedulev20.model.Dao.UsuarioDAO;
import com.example.easyschedulev20.model.LocacaoQuadra;
import com.example.easyschedulev20.model.Notificacao;
import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.model.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, LocacaoQuadra.class, QuadraEsportiva.class, Notificacao.class}, version = 3, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "UserRepository") .fallbackToDestructiveMigration().allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UsuarioDAO usuarioDAO();
    public abstract LocacaoQuadraDAO locacaoQuadraDAO();
    public abstract QuadraEsportivaDAO quadraEsportivaDAO();
    public abstract NotificacaoDAO notificacaoDAO();

}