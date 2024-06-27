package com.example.easyschedulemob.ui.login;

import android.app.Application;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.easyschedulemob.model.Usuario;
import com.example.easyschedulemob.model.Repository.UserRepository;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final UserRepository userRepository;
    private final MutableLiveData<Usuario> usuarioLiveData;

    public LoginViewModel(Application application) {
        super(application);
        mText = new MutableLiveData<>();
        mText.setValue("This is login fragment");
        userRepository = new UserRepository(application);
        usuarioLiveData = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Usuario> getUsuarioLiveData() {
        return usuarioLiveData;
    }

    public void listarUsuarioPeloEmail(String email) {
        Usuario usuario = userRepository.listarUsuarioPeloEmail(email);
        usuarioLiveData.setValue(usuario);
    }
}
