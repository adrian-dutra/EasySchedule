package com.example.easyschedulemob.model.Repository;

import android.app.Application;
import com.example.easyschedulemob.core.AppDatabase;
import com.example.easyschedulemob.model.LocacaoQuadra;
import com.example.easyschedulemob.model.Dao.LocacaoQuadraDAO;

import java.time.LocalDate;
import java.util.List;

public class LocacaoQuadraRepository {
    private LocacaoQuadraDAO locacaoQuadraDAO;

    public LocacaoQuadraRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        locacaoQuadraDAO = db.locacaoQuadraDAO();
    }

    public void inserirLocacao(LocacaoQuadra locacao) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locacaoQuadraDAO.insert(locacao);
        });
    }

    public LocacaoQuadra buscarLocacaoPorId(int id){
        return locacaoQuadraDAO.getLocacaoById(id);
    }

    public List<LocacaoQuadra> buscarLocacaoPorQuadraId(int quadraId){
        return locacaoQuadraDAO.getLocacoesByQuadraId(quadraId);
    }

    public LocacaoQuadra buscarPorHorario(int idQuadra, LocalDate data, String horaInicio, String horaFim){
        return locacaoQuadraDAO.getLocacaoByHorario(idQuadra, data, horaInicio, horaFim);
    }

    public List<LocacaoQuadra> buscarLocacoesPorLocatario(int userId){
        return locacaoQuadraDAO.getLocacoesByUserId(userId);
    }

    public List<LocacaoQuadra> listarTodasAsLocacoes(){
        return locacaoQuadraDAO.getAllLocacoes();
    }

    public void atualizarLocacao(LocacaoQuadra locacao){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locacaoQuadraDAO.update(locacao);
        });
    }

    public void deletarLocacao(LocacaoQuadra locacao){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locacaoQuadraDAO.delete(locacao);
        });
    }
}
