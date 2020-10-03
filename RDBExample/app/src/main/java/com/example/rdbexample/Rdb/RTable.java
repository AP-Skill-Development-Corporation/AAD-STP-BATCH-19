package com.example.rdbexample.Rdb;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RTable {

    @PrimaryKey
    @NonNull
    String roll;

    //Below is the way to generate the Id or serial no by auto increment
    /*@PrimaryKey(autoGenerate = true)
    int id;*/

    String name,number;

    @NonNull
    public String getRoll() {
        return roll;
    }

    public void setRoll(@NonNull String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
