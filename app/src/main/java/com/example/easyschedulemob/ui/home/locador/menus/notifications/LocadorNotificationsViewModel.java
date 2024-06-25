package com.example.easyschedulemob.ui.home.locador.menus.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocadorNotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LocadorNotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}