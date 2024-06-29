package com.example.easyschedulev20.view.locador.ui.notifications;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.easyschedulev20.model.Notificacao;
import com.example.easyschedulev20.model.Repository.NotificacaoRepository;
import java.util.List;

public class NotificationsLocadorViewModel extends ViewModel {

    private NotificacaoRepository notificacaoRepository;

    public NotificationsLocadorViewModel() {

    }

    public List<Notificacao> getAllNotificacoesByUserId(Application context, int userId) {
        if (notificacaoRepository == null) {
            notificacaoRepository = new NotificacaoRepository(context);
        }
        return notificacaoRepository.getAllNotificacoesByUserId(userId);
    }
}