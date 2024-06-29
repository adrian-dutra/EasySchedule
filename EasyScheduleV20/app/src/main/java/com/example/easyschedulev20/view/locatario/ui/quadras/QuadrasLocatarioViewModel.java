package com.example.easyschedulev20.view.locatario.ui.quadras;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.model.Repository.QuadraEsportivaRepository;

import java.util.List;

public class QuadrasLocatarioViewModel extends ViewModel {

    private QuadraEsportivaRepository quadraEsportivaRepository;

    public QuadrasLocatarioViewModel() {

    }

    public List<QuadraEsportiva> listarQuadras(Application context){
        quadraEsportivaRepository = new QuadraEsportivaRepository(context);
        return quadraEsportivaRepository.listarTodasAsQuadras();
    }

}