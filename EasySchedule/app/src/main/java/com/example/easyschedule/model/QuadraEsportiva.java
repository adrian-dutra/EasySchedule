package com.example.easyschedule.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "quadraesportiva",
        foreignKeys = @ForeignKey(entity = Usuario.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = ForeignKey.CASCADE))
public class QuadraEsportiva {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nome;
    String tipo;
    Double precoPorHora;
    int userId;
    int disponivel;
    public QuadraEsportiva(String nome, String tipo, double precoPorHora, int disponivel, int userId) {
        this.nome = nome;
        this.tipo = tipo;
        this.precoPorHora = precoPorHora;
        this.disponivel = 1;
        this.userId = userId;
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

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
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
