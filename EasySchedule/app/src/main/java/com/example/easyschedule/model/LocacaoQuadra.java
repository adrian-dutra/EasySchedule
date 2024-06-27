package com.example.easyschedule.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(
        tableName = "locacoes",
        foreignKeys = {
                @ForeignKey(
                        entity = QuadraEsportiva.class,
                        parentColumns = "quadraEsportivaId",
                        childColumns = "quadraEsportivaId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Usuario.class,
                        parentColumns = "userId",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("quadraEsportivaId"),
                @Index("userId")
        }
)
public class LocacaoQuadra {
    @PrimaryKey(autoGenerate = true)
    int id;
    int quadraEsportivaId;
    int userId;
    LocalDate data;
    String horaInicio;
    String horaFim;
    public LocacaoQuadra(int quadraEsportivaId, int userId, LocalDate data, String horaInicio, String horaFim) {
        //if (quadra.isDisponivel() == 0) {
        //throw new IllegalArgumentException("A quadra não está disponível para locação.");
        //}
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.quadraEsportivaId = quadraEsportivaId;
        this.userId = userId;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuadraEsportivaId() { return quadraEsportivaId; }
    public void setQuadraEsportivaId(int quadraEsportivaId) { this.quadraEsportivaId = quadraEsportivaId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    /*public double calcularValor() {
        long horas = java.time.Duration.between(horaInicio, horaFim).toHours();
        return horas * quadra.getPrecoPorHora();
    }*/

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String toString() {
        return "LocacaoQuadra{" +
                "id=" + this.id +
                ", data=" + data +
                "horaInicio = " + this.horaInicio +
                "horaFim = " + this.horaFim +
                '}';
    }

}
