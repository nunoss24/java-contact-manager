package io.spotny.contacts.repositories;

import java.util.ArrayList;
import java.util.List;

import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.dal.Repository;

public class InMemoryPersonsRepositories implements Repository<Person> {

    private final List<Person> data;

    public InMemoryPersonsRepositories() {
        data = new ArrayList<>();
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
    }

    @Override
    public void update(Person element) {
        int index = data.indexOf(element);
        if(index != -1) {
            data.set(index, element);
        }
    }

    @Override
    public void delete(Person element) {
        data.remove(element);
    }

    @Override
    public void delete(String id) {
        if(data == null) {
            return;
        }

        data.removeIf(person -> person.getId().equals(id));
    }
}