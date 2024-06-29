package com.example.easyschedulev20.model.Repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.easyschedulev20.core.AppDatabase;
import com.example.easyschedulev20.model.Dao.NotificacaoDAO;
import com.example.easyschedulev20.model.Notificacao;
import java.util.List;

public class NotificacaoRepository {

    private NotificacaoDAO notificacaoDAO;
    private LiveData<List<Notificacao>> allNotificacoes;

    public NotificacaoRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        notificacaoDAO = db.notificacaoDAO();
    }


    public void insert(Notificacao notificacao) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            notificacaoDAO.insert(notificacao);
        });
    }

    public LiveData<List<Notificacao>> getAllNotificacoesByUserId(int userId) {
        return (LiveData<List<Notificacao>>) notificacaoDAO.getNotificacoesByUserId(userId);
    }

    public void delete(Notificacao notificacao) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            notificacaoDAO.delete(notificacao);
        });
    }

}
