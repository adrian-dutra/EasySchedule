package com.example.easyschedulev20.view.locador.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsLocadorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NotificationsLocadorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}