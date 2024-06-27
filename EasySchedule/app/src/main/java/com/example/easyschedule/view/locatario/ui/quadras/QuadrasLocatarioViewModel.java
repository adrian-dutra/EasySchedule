package com.example.easyschedule.view.locatario.ui.quadras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuadrasLocatarioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public QuadrasLocatarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}