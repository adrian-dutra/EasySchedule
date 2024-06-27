package com.example.easyschedule.model.Repository;

import android.app.Application;
import com.example.easyschedule.core.AppDatabase;
import com.example.easyschedule.model.Usuario;
import com.example.easyschedule.model.Dao.UsuarioDAO;

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
