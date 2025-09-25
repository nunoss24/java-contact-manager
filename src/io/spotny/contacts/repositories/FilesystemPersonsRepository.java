package io.spotny.contacts.repositories;

import java.util.ArrayList;
import java.util.List;

import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.BinaryFile;

public class FilesystemPersonsRepository extends BinaryFile<List<Person>> implements PersonRepository{
    
      private final List<Person> data;

    public FilesystemPersonsRepository() {
        super("persons.db");
        var fileContent = read();
        data = fileContent != null ? fileContent : new ArrayList<>();
    }

    @Override
    public List<Person> findAll() {
        return data;
    }

    @Override
    public Person findById(String id) {
        return data
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void insert(Person element) {
        data.add(element);
        write(data);
    }

    @Override
    public void update(Person element) {
        int index = data.indexOf(element);
        if(index != -1) {
            data.set(index, element);
        }
        write(data);
    }

    @Override
    public void delete(Person element) {
        data.remove(element);
        write(data);
    }

    @Override
    public void delete(String id) {
        if(data == null) {
            return;
        }

        data.removeIf(person -> person.getId().equals(id));
        write(data);
    }
}
