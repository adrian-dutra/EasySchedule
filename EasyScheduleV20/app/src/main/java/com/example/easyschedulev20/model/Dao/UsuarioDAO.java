package com.example.easyschedulev20.model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.easyschedulev20.model.Usuario;

import java.util.List;
@Dao
public interface UsuarioDAO {
    @Query("SELECT * FROM Usuario WHERE userId=:idUser LIMIT 1")
    Usuario getUser(int idUser);
    @Query("SELECT * FROM Usuario")
    List<Usuario> getAll();
    @Query("SELECT * FROM usuario WHERE email like :userEmail")
    Usuario getUserByEmail(String userEmail);
    @Insert
    void insertAll(Usuario user);
    @Update
    void update(Usuario user);
    @Delete
    void delete(Usuario user);
}
