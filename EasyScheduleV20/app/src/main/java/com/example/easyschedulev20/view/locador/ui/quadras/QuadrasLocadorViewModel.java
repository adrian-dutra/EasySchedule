package com.example.easyschedulev20.view.locador.ui.quadras;


import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.model.Repository.QuadraEsportivaRepository;

import java.util.List;

public class QuadrasLocadorViewModel extends ViewModel {

    private QuadraEsportivaRepository quadraRepository;

    public QuadrasLocadorViewModel() {

    }

    public List<QuadraEsportiva> listarQuadras(Application context){
        quadraRepository = new QuadraEsportivaRepository(context);
        return quadraRepository.listarTodasAsQuadras();
    }

}