package com.example.easyschedulev20.view.LocacaoQuadra;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.easyschedulev20.model.LocacaoQuadra;
import com.example.easyschedulev20.model.Repository.LocacaoQuadraRepository;

public class LocacaoQuadraViewModel extends ViewModel {

    private LocacaoQuadraRepository locacaoQuadraRepository;

    public LocacaoQuadraViewModel(){

    }

    public void inserirLocacao(LocacaoQuadra locacaoQuadra, Application context){

        locacaoQuadraRepository = new LocacaoQuadraRepository(context);
        locacaoQuadraRepository.inserirLocacao(locacaoQuadra);

    }

}