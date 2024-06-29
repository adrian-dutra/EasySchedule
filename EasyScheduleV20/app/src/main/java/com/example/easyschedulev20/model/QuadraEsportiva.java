package com.example.easyschedulev20.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "quadraesportiva",
        foreignKeys = @ForeignKey(entity = Usuario.class,
                parentColumns = "userId",
                childColumns = "userId",
                onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"userId"})
        })
public class QuadraEsportiva implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int quadraEsportivaId;
    String nome;
    String tipo;
    double precoPorHora;
    int userId;
    int disponivel;
    public QuadraEsportiva(String nome, String tipo, double precoPorHora, int disponivel, int userId) {
        this.nome = nome;
        this.tipo = tipo;
        this.precoPorHora = precoPorHora;
        this.disponivel = disponivel;
        this.userId = userId;
    }

    public int getQuadraEsportivaId() {
        return quadraEsportivaId;
    }
    public void setQuadraEsportivaId(int quadraEsportivaId) {
        this.quadraEsportivaId = quadraEsportivaId;
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
    public int getDisponivel() {
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
