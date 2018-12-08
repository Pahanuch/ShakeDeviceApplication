package com.tikhonov.paul.shakedeviceapplication.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EnergyDao {

    @Query("SELECT * FROM energy")
    List<Energy> getAll();

    @Query("SELECT * FROM energy WHERE id = :id")
    Energy getById(long id);

    @Insert
    void insert(Energy energy);

    @Update
    void update(Energy energy);

    @Delete
    void delete(Energy energy);

}