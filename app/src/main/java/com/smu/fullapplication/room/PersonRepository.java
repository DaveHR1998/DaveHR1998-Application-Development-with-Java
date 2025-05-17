package com.smu.fullapplication.room;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executors;

public class PersonRepository {
    private final PersonDao personDao;
    private final LiveData<List<PersonEntity>> allPersons;

    public PersonRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        personDao = db.personDao();
        allPersons = personDao.getAllPersons();
    }

    public LiveData<List<PersonEntity>> getAllPersons() {
        return allPersons;
    }

    public void insert(PersonEntity person) {
        Executors.newSingleThreadExecutor().execute(() -> personDao.insert(person));
    }

    public void update(PersonEntity person) {
        Executors.newSingleThreadExecutor().execute(() -> personDao.update(person));
    }

    public void delete(PersonEntity person) {
        Executors.newSingleThreadExecutor().execute(() -> personDao.delete(person));
    }
}
