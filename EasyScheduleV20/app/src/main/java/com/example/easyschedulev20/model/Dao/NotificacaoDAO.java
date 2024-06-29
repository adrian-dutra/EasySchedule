package com.example.easyschedulev20.model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.easyschedulev20.model.Notificacao;

import java.util.List;

@Dao
public interface NotificacaoDAO {

    @Insert
    void insert(Notificacao notification);

    @Delete
    void delete(Notificacao notification);

    @Query("SELECT * FROM notificacao")
    List<Notificacao> getAllNotificacoes();

    @Query("SELECT * FROM notificacao WHERE userId = :userId")
    List<Notificacao> getNotificacoesByUserId(int userId);
}
