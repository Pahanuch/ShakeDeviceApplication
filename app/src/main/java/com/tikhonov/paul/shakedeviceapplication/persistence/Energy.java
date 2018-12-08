package com.tikhonov.paul.shakedeviceapplication.persistence;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Energy {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public boolean spending;

    public Long time;
}
