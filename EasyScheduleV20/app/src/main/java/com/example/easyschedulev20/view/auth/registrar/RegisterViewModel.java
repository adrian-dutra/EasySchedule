package com.example.easyschedulev20.view.auth.registrar;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.easyschedulev20.model.Repository.UserRepository;
import com.example.easyschedulev20.model.Usuario;


public class RegisterViewModel extends ViewModel {

    private UserRepository repository;
    private final MutableLiveData<String> mText;

    public RegisterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public void registrarUsuario(Usuario usuario, Application context) {
        repository = new UserRepository(context);
        repository.inserirUsuario(usuario);
    }
    public Usuario buscarUsuarioPeloEmail(String email, Application context) {
        repository = new UserRepository(context);
        return repository.listarUsuarioPeloEmail(email);
    }
    public LiveData<String> getText() {
        return mText;
    }
}