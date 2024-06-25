package com.example.easyschedulemob.ui.home.locatario.menus.locacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocatarioLocacoesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LocatarioLocacoesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}