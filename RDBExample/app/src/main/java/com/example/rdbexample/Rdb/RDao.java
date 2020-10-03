package com.example.rdbexample.Rdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RDao {

    @Insert
    void insert(RTable rTable);

    @Update
    void update(RTable rTable);

    @Delete
    void delete(RTable rTable);

    @Query("Select * from RTable")
    List<RTable> getAll();

}
