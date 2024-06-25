package com.example.easyschedulemob.model.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.easyschedulemob.model.Locatario;
import java.util.List;

@Dao
public interface LocatarioDAO {
    @Insert
    void insert(Locatario locatario);

    @Update
    void update(Locatario locatario);

    @Delete
    void delete(Locatario locatario);

    @Query("SELECT * FROM locatario WHERE id = :id LIMIT 1")
    Locatario getLocatarioById(int id);

    @Query("SELECT * FROM locatario WHERE userId = :userId LIMIT 1")
    Locatario getLocatarioByUserId(int userId);

    @Query("SELECT * FROM locatario")
    List<Locatario> getAllLocatarios();
}
