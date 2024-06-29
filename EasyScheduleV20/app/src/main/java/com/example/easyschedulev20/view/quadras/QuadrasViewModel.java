package com.example.easyschedulev20.view.quadras;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.model.Repository.QuadraEsportivaRepository;

public class QuadrasViewModel extends ViewModel {

    private QuadraEsportivaRepository quadrasRepository;

    public QuadrasViewModel(){

    }

    public void registrarQuadra(QuadraEsportiva quadra, Application context){
        quadrasRepository = new QuadraEsportivaRepository(context);
        quadrasRepository.inserirQuadra(quadra);
    }


}