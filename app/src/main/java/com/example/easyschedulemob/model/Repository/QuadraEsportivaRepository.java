package com.example.easyschedulemob.model.Repository;

import android.app.Application;
import com.example.easyschedulemob.core.AppDatabase;
import com.example.easyschedulemob.model.QuadraEsportiva;
import com.example.easyschedulemob.model.Dao.QuadraEsportivaDAO;

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
}
