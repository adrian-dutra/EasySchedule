package com.example.easyschedulemob.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(
        tableName = "locacoes",
        foreignKeys = {
                @ForeignKey(
                        entity = QuadraEsportiva.class,
                        parentColumns = "id",
                        childColumns = "quadraId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Locatario.class,
                        parentColumns = "id",
                        childColumns = "locatarioId",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class LocacaoQuadra {
    @PrimaryKey(autoGenerate = true)
    int id;
    int quadraEsportivaId;
    int locatarioId;
    LocalDate data;
    String horaInicio;
    String horaFim;
    public LocacaoQuadra(int quadraEsportivaId, int locatarioId, LocalDate data, String horaInicio, String horaFim) {
        //if (quadra.isDisponivel() == 0) {
            //throw new IllegalArgumentException("A quadra não está disponível para locação.");
        //}
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.quadraEsportivaId = quadraEsportivaId;
        this.locatarioId = locatarioId;
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

    public int getLocatarioId() { return locatarioId; }
    public void setLocatarioId(int locatarioId) { this.locatarioId = locatarioId; }

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
