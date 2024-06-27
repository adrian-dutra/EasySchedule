package com.example.easyschedule.model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.easyschedulemob.model.QuadraEsportiva;

import java.util.List;

@Dao
public interface QuadraEsportivaDAO {
    @Insert
    void insert(QuadraEsportiva quadra);

    @Update
    void update(QuadraEsportiva quadra);

    @Delete
    void delete(QuadraEsportiva quadra);

    @Query("SELECT * FROM quadraesportiva WHERE id = :id LIMIT 1")
    QuadraEsportiva getQuadraById(int id);

    @Query("SELECT * FROM quadraesportiva")
    List<QuadraEsportiva> getAllQuadras();
}
