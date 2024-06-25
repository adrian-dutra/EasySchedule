package com.example.easyschedulemob.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(foreignKeys = @ForeignKey(entity = Usuario.class,
        parentColumns = "id",
        childColumns = "userId",
        onDelete = ForeignKey.CASCADE))
public class Locatario extends Usuario{
    @PrimaryKey(autoGenerate = true)
    int id;
    String CPF;

    public Locatario(String nome, String email, String password, String tipoUsuario, String CPF) {
        super(nome, email, password, tipoUsuario);
        this.CPF = CPF;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", CPF: " + CPF;
    }
}
