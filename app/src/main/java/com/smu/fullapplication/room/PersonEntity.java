package com.smu.fullapplication.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class PersonEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public int age;

    public PersonEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

