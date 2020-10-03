package com.example.rdbexample.Rdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RTable.class},version = 1,exportSchema = false)
public abstract class RDatabase extends RoomDatabase {
    public abstract RDao rDao();
}
