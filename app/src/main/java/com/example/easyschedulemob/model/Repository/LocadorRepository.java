package com.example.easyschedulemob.model.Repository;

import android.app.Application;
import com.example.easyschedulemob.core.AppDatabase;
import com.example.easyschedulemob.model.Locador;
import com.example.easyschedulemob.model.Dao.LocadorDAO;

import java.util.List;

public class LocadorRepository {
    private LocadorDAO locadorDao;

    public LocadorRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        locadorDao = db.locadorDAO();
    }

    public void inserirLocador(Locador locador) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locadorDao.insert(locador);
        });
    }

    public Locador listarLocadorPeloId(int id){
        return locadorDao.getLocadorById(id);
    }

    public Locador listarLocadorPeloUserId(int userId){
        return locadorDao.getLocadorByUserId(userId);
    }

    public void atualizarLocador(Locador locador){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locadorDao.update(locador);
        });
    }

    public void deletarLocador(Locador locador){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locadorDao.delete(locador);
        });
    }

    public List<Locador> listarLocadores(){
        return locadorDao.getAllLocadores();
    }
}
