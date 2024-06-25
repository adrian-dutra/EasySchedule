package com.example.easyschedulemob.model.Repository;

import android.app.Application;
import com.example.easyschedulemob.core.AppDatabase;
import com.example.easyschedulemob.model.Locatario;
import com.example.easyschedulemob.model.Dao.LocatarioDAO;

import java.util.List;

public class LocatarioRepository {
    private LocatarioDAO locatarioDao;

    public LocatarioRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        locatarioDao = db.locatarioDAO();
    }

    public void inserirLocatario(Locatario locatario) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locatarioDao.insert(locatario);
        });
    }

    public Locatario listarLocatarioPeloId(int id){
        return locatarioDao.getLocatarioById(id);
    }

    public Locatario listarLocatarioPeloUserId(int userId){
        return locatarioDao.getLocatarioByUserId(userId);
    }

    public void atualizarLocatario(Locatario locatario){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locatarioDao.update(locatario);
        });
    }

    public void deletarLocatario(Locatario locatario){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            locatarioDao.delete(locatario);
        });
    }

    public List<Locatario> listarLocatarios(){
        return locatarioDao.getAllLocatarios();
    }
}
