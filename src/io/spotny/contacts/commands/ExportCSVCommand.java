package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.TextFile;
import io.spotny.contacts.persistence.dal.Repository;
import io.spotny.contacts.services.CSVExporterService;

public class ExportCSVCommand {
    private final Repository<Person> repository;
    private final Scanner keyboard;
    private final CSVExporterService csvExporterService;

    public ExportCSVCommand(Scanner keyboard, Repository<Person> repository, CSVExporterService csvExporterService) {
        this.keyboard = keyboard;
        this.repository = repository;
        this.csvExporterService = csvExporterService;
    }

    public void execute() {
        Console.title("Export Contacts to CSV");
        Console.inputOption("File name:");
        var fileName = keyboard.next();

        var file = new TextFile(fileName);
        file.delete();

        file.writeLine("SEP=;");
        file.writeLine("ID;Name;Email");

        var persons = repository.findAll();

        persons
            .stream()
            .map(person -> String.format("%s;%s;%s", person.getId(), person.getName(), person.getEmail()))
            .forEach(file::writeLine);
    }
}
