package com.example.easyschedulemob.model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.easyschedulemob.model.LocacaoQuadra;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface LocacaoQuadraDAO {
    @Insert
    void insert(LocacaoQuadra locacao);

    @Update
    void update(LocacaoQuadra locacao);

    @Delete
    void delete(LocacaoQuadra locacao);

    @Query("SELECT * FROM locacoes WHERE id = :id LIMIT 1")
    LocacaoQuadra getLocacaoById(int id);

    @Query("SELECT * FROM locacoes WHERE quadraEsportivaId = :quadraId")
    List<LocacaoQuadra> getLocacoesByQuadraId(int quadraId);

    @Query("SELECT * FROM locacoes WHERE quadraEsportivaId = :idQuadra AND data = :data AND ((horaInicio <= :horaFim AND horaFim > :horaInicio) OR (horaInicio >= :horaInicio AND horaInicio <= :horaFim))")
    LocacaoQuadra getLocacaoByHorario(int idQuadra, LocalDate data, String horaInicio, String horaFim);

    @Query("SELECT * FROM locacoes WHERE userId = :userId")
    List<LocacaoQuadra> getLocacoesByUserId(int userId);

    @Query("SELECT * FROM locacoes")
    List<LocacaoQuadra> getAllLocacoes();
}
