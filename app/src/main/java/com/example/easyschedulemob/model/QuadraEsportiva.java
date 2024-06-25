package com.example.easyschedulemob.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "quadraesportiva",
        foreignKeys = @ForeignKey(entity = Locador.class,
                parentColumns = "id",
                childColumns = "locadorId",
                onDelete = ForeignKey.CASCADE))
public class QuadraEsportiva {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nome;
    String tipo;
    Double precoPorHora;
    int locadorId;
    int disponivel;
    public QuadraEsportiva(String nome, String tipo, double precoPorHora, int disponivel, int locadorId) {
        this.nome = nome;
        this.tipo = tipo;
        this.precoPorHora = precoPorHora;
        this.disponivel = 1;
        this.locadorId = locadorId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public int getLocadorId() { return locadorId; }
    public void setLocadorId(int locadorId) { this.locadorId = locadorId; }
    public int isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "QuadraEsportiva{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precoPorHora=" + precoPorHora +
                ", disponivel=" + disponivel +
                '}';
    }
}
