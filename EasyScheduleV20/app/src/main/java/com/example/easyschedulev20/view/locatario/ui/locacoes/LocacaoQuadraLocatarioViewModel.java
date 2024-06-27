package com.example.easyschedulev20.view.locatario.ui.locacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocacaoQuadraLocatarioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LocacaoQuadraLocatarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}