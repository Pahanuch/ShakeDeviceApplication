package com.tikhonov.paul.shakedeviceapplication.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Energy.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EnergyDao energyDao();
}