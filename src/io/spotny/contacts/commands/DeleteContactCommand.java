package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.dal.Repository;

public class DeleteContactCommand {
    private final Scanner keyboard;
    private final Repository<Person> repository;

    public DeleteContactCommand(Scanner keyboard, Repository<Person> repository) {
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
