package com.example.easyschedulemob.ui.home.locatario.menus.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsLocatarioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NotificationsLocatarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}