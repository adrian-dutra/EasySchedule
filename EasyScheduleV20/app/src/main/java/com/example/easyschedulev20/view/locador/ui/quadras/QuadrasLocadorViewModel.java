package com.example.easyschedule.view.locador.ui.quadras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuadrasLocadorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public QuadrasLocadorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}