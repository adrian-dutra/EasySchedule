package com.example.easyschedulemob.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public abstract class Usuario {
    @PrimaryKey(autoGenerate = true)
    protected int userId;
    protected String nome;
    protected String email;
    protected String password;
    protected String tipoUsuario;

    public Usuario(String nome, String email, String password, String tipoUsuario){
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
