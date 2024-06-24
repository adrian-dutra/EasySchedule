package com.example.easyschedulemob.model.Repository;

import android.app.Application;
import com.example.easyschedulemob.core.AppDatabase;
import com.example.easyschedulemob.model.Usuario;
import com.example.easyschedulemob.model.Dao.UsuarioDAO;

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
