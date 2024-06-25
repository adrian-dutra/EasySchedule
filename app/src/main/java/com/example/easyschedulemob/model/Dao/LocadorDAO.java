package com.example.easyschedulemob.model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.easyschedulemob.model.Locador;
import java.util.List;

@Dao
public interface LocadorDAO {
    @Insert
    void insert(Locador locador);

    @Update
    void update(Locador locador);

    @Delete
    void delete(Locador locador);

    @Query("SELECT * FROM locador WHERE id = :id LIMIT 1")
    Locador getLocadorById(int id);

    @Query("SELECT * FROM locador WHERE userId = :userId LIMIT 1")
    Locador getLocadorByUserId(int userId);

    @Query("SELECT * FROM locador")
    List<Locador> getAllLocadores();
}
