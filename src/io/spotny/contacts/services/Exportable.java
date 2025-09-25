package io.spotny.contacts.services;

import java.util.List;

import io.spotny.contacts.models.Person;

public interface Exportable {
    void export(String fileName, List<Person> persons);
}
