package com.example.easyschedule.model.Repository;

import android.app.Application;


import com.example.easyschedule.core.AppDatabase;
import com.example.easyschedule.model.Dao.QuadraEsportivaDAO;
import com.example.easyschedule.model.QuadraEsportiva;

import java.util.List;

public class QuadraEsportivaRepository {
    private QuadraEsportivaDAO quadraEsportivaDAO;

    public QuadraEsportivaRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        quadraEsportivaDAO = db.quadraEsportivaDAO();
    }

    public void inserirQuadra(QuadraEsportiva quadra) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            quadraEsportivaDAO.insert(quadra);
        });
    }

    public QuadraEsportiva buscarQuadraPorId(int id){
        return quadraEsportivaDAO.getQuadraById(id);
    }

    public void atualizarQuadra(QuadraEsportiva quadra){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            quadraEsportivaDAO.update(quadra);
        });
    }

    public void deletarQuadra(QuadraEsportiva quadra){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            quadraEsportivaDAO.delete(quadra);
        });
    }

    public List<QuadraEsportiva> listarTodasAsQuadras(){
        return quadraEsportivaDAO.getAllQuadras();
    }
}
