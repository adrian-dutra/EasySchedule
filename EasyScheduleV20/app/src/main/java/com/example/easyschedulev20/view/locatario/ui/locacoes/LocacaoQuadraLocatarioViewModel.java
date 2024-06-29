package com.example.easyschedulev20.view.locatario.ui.locacoes;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.easyschedulev20.model.LocacaoQuadra;
import com.example.easyschedulev20.model.Repository.LocacaoQuadraRepository;

import java.util.List;

public class LocacaoQuadraLocatarioViewModel extends ViewModel {

    private LocacaoQuadraRepository locacaoQuadraRepository;

    public LocacaoQuadraLocatarioViewModel() {

    }

    public List<LocacaoQuadra> listarLocacoes(Application context){
        locacaoQuadraRepository = new LocacaoQuadraRepository(context);
        return locacaoQuadraRepository.listarTodasAsLocacoes();
    }

}