package com.example.easyschedulev20.view.locador.ui.locacao;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.easyschedulev20.model.LocacaoQuadra;
import com.example.easyschedulev20.model.Repository.LocacaoQuadraRepository;

import java.util.List;

public class LocacaoQuadraLocadorViewModel extends ViewModel {

    private LocacaoQuadraRepository locacaoQuadraRepository;

    public LocacaoQuadraLocadorViewModel() {

    }

    public List<LocacaoQuadra> listarLocacoes(Application context){
        locacaoQuadraRepository = new LocacaoQuadraRepository(context);
        return locacaoQuadraRepository.listarTodasAsLocacoes();
    }

}