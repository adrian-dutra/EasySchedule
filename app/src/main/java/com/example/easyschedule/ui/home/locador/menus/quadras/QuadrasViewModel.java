package com.example.easyschedule.ui.home.locador.menus.quadras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuadrasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public QuadrasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}