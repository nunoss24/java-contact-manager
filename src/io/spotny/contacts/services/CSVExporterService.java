package io.spotny.contacts.services;

import java.util.List;

import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.TextFile;

public class CSVExporterService implements Exportable {
    public void export(String fileName, List<Person> persons) {
        var file = new TextFile(fileName);
        file.delete();

        file.writeLine("SEP=;");
        file.writeLine("ID;Name;Contacts");


        persons
                .stream()
                .map(person -> String.format("%s;%s;%s", person.getId(), person.getName(), person.getContacts().stream().map(c -> c.getType() + ":" + c.getValue()).reduce((a, b) -> a + "," + b).orElse("")))
                .forEach(file::writeLine);
    }
}
