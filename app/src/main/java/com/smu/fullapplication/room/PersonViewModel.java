package com.smu.fullapplication.room;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {
    private final PersonRepository repository;
    private final LiveData<List<PersonEntity>> allPersons;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        repository = new PersonRepository(application);
        allPersons = repository.getAllPersons();
    }

    public LiveData<List<PersonEntity>> getAllPersons() {
        return allPersons;
    }

    public void insert(PersonEntity person) {
        repository.insert(person);
    }

    public void update(PersonEntity person) {
        repository.update(person);
    }

    public void delete(PersonEntity person) {
        repository.delete(person);
    }
}
