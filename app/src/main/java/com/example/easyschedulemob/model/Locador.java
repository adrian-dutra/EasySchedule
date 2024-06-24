package com.example.easyschedulemob.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Locador extends Usuario {
    @PrimaryKey(autoGenerate = true)
    int id;
    private String CNPJ;
    private int nQuadras;

    public Locador(String nome, String email, String password, String tipoUsuario, String CNPJ) {
        super(nome, email, password, tipoUsuario);
        this.CNPJ = CNPJ;
        this.nQuadras = 0;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        this.CNPJ = cNPJ;
    }

    public int getNQuadras() {
        return nQuadras;
    }

    public void setNQuadras(int nQuadras) {
        this.nQuadras = nQuadras;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", CNPJ: " + CNPJ;
    }
}
