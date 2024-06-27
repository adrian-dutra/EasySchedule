package com.example.easyschedule.ui.home.locador.menus.locacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocacoesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LocacoesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}