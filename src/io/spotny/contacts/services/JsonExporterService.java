package io.spotny.contacts.services;

import java.util.List;

import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.TextFile;

public class JsonExporterService implements Exportable {
    public void export(String filePath, List<Person> contacts) {
        var file = new TextFile(filePath);
        file.delete();

        file.writeLine("[\n");

        contacts
                .stream()
                .map(person -> {
                    var contactsJson = person.getContacts()
                            .stream()
                            .map(c -> String.format("{\"type\":\"%s\",\"value\":\"%s\"}", c.getType(), c.getValue()))
                            .reduce((a, b) -> a + "," + b)
                            .orElse("");

                    return String.format("  {\"id\":\"%s\",\"name\":\"%s\",\"contacts\":[%s]}", person.getId(),
                            person.getName(), contactsJson);
                })
                .reduce((a, b) -> a + "," + b)
                .ifPresent(file::writeLine);

        file.writeLine("]");
    }
}
