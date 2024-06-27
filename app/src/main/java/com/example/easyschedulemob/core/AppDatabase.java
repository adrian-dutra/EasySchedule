package com.example.easyschedulemob.core;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.easyschedulemob.model.Converters;
import com.example.easyschedulemob.model.LocacaoQuadra;
import com.example.easyschedulemob.model.QuadraEsportiva;
import com.example.easyschedulemob.model.Dao.UsuarioDAO;
import com.example.easyschedulemob.model.Dao.LocacaoQuadraDAO;
import com.example.easyschedulemob.model.Dao.QuadraEsportivaDAO;
import com.example.easyschedulemob.model.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, LocacaoQuadra.class, QuadraEsportiva.class}, version = 1, exportSchema = false)
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
                                    AppDatabase.class, "UserRepository") .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UsuarioDAO usuarioDAO();
    public abstract LocacaoQuadraDAO locacaoQuadraDAO();
    public abstract QuadraEsportivaDAO quadraEsportivaDAO();

}
