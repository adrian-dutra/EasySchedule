package com.example.easyschedulev20.model;

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
    String horaInicio;
    String horaFim;
    public LocacaoQuadra(int quadraEsportivaId, int userId, String horaInicio, String horaFim) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.quadraEsportivaId = quadraEsportivaId;
        this.userId = userId;
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
                "horaInicio = " + this.horaInicio +
                "horaFim = " + this.horaFim +
                '}';
    }

}
