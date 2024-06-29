package com.example.easyschedulev20.model.Repository;

import android.app.Application;


import com.example.easyschedulev20.core.AppDatabase;
import com.example.easyschedulev20.model.Dao.QuadraEsportivaDAO;
import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.view.locador.LocadorActivity;

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

    public QuadraEsportiva buscarQuadraPorId(int quadraEsportivaId){
        return quadraEsportivaDAO.getQuadraById(quadraEsportivaId);
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

    public void observe(LocadorActivity locadorActivity, Object o) {
    }
}
