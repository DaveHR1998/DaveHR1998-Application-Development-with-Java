package com.smu.fullapplication.room;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert
    void insert(PersonEntity person);

    @Update
    void update(PersonEntity person);

    @Delete
    void delete(PersonEntity person);

    @Query("SELECT * FROM person ORDER BY id DESC")
    LiveData<List<PersonEntity>> getAllPersons();
}
