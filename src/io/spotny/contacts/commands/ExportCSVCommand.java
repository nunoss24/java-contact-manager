package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.repositories.PersonRepository;
import io.spotny.contacts.services.Exportable;

public class ExportCSVCommand implements Command{
    private final PersonRepository repository;
    private final Scanner keyboard;
    private final Exportable csvExporterService;

    public ExportCSVCommand(Scanner keyboard, PersonRepository repository, Exportable csvExporterService) {
        this.keyboard = keyboard;
        this.repository = repository;
        this.csvExporterService = csvExporterService;
    }

    public void execute() {
        Console.title("Export Contacts to CSV");
        Console.inputOption("File name:");
        var fileName = keyboard.next();
        var persons = repository.findAll();

        csvExporterService.export(fileName, persons);
    }
}
