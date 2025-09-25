package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.repositories.PersonRepository;

public class SearchContactCommand implements Command{

    private final Scanner keyboard;
    private final PersonRepository repository;

    public SearchContactCommand(Scanner keyboard, PersonRepository repository) {
        this.keyboard = keyboard;
        this.repository = repository;
    }

    public void execute() {
        Console.title("Search Contact");
        Console.inputOption("Person ID:");
        var id = keyboard.next();

        var person = repository.findById(id);

        if (person == null) {
            Console.line('-');
            Console.text("Contact not found.");
            Console.line('-');
            return;
        }

        Console.line('-');
        Console.text("ID" + person.getId());
        Console.text("Name: " + person.getName());
        Console.text("Contacts:");
        person.getContacts().forEach(contact -> Console.text("\t - " + contact.getType() + ": " + contact.getValue()));
        Console.line('-');
    }
}
