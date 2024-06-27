package com.example.easyschedulev20.model.Repository;

import android.app.Application;

import com.example.easyschedulev20.core.AppDatabase;
import com.example.easyschedulev20.model.Dao.UsuarioDAO;
import com.example.easyschedulev20.model.Usuario;

import java.util.List;

public class UserRepository {
    UsuarioDAO usuarioDao;
    public UserRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        usuarioDao = db.usuarioDAO();
    }

    public void inserirUsuario(Usuario usuario) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            usuarioDao.insertAll(usuario);
        });
    }

    public Usuario listarUsuarioPeloId(int id){
        return  usuarioDao.getUser(id);
    }

    public Usuario listarUsuarioPeloEmail(String email){
        return  usuarioDao.getUserByEmail(email);
    }

    public void atualizarUsuario(Usuario user){
        usuarioDao.update(user);
    }

    public void deletarUsuario(Usuario user){
        usuarioDao.delete(user);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioDao.getAll();
    }
}
