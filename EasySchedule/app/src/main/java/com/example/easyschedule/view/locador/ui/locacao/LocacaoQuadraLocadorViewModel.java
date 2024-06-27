package com.example.easyschedule.view.locador.ui.locacao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocacaoQuadraLocadorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LocacaoQuadraLocadorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}