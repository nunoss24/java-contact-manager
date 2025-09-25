package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.repositories.PersonRepository;

public class DeleteContactCommand implements Command {
    private final Scanner keyboard;
    private final PersonRepository repository;

    public DeleteContactCommand(Scanner keyboard, PersonRepository repository) {
        this.keyboard = keyboard;
        this.repository = repository;
    }

    public void execute() {
        Console.title("Delete Contact");
        Console.inputOption("Person ID:");
        var id = keyboard.next();

        repository.delete(id);
    }
}
