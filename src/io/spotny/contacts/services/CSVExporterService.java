package io.spotny.contacts.services;

import java.util.List;

import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.TextFile;

public class CSVExporterService {
    public void export(String fileName, List<Person> persons) {
        var file = new TextFile(fileName);
        file.delete();

        file.writeLine("SEP=;");
        file.writeLine("ID;Name;Email");


        persons
                .stream()
                .map(person -> String.format("%s;%s;%s", person.getId(), person.getName(), person.getEmail()))
                .forEach(file::writeLine);
    }
}
