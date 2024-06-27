package com.example.easyschedule.ui.home.locatario.menus.quadras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocatarioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LocatarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}