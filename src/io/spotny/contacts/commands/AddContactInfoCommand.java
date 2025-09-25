package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Contact;
import io.spotny.contacts.models.ContactType;
import io.spotny.contacts.repositories.PersonRepository;

public class AddContactInfoCommand implements Command {
    private final Scanner keyboard;
    private final PersonRepository personRepository;

    public AddContactInfoCommand(Scanner keyboard, PersonRepository personRepository) {
        this.keyboard = keyboard;
        this.personRepository = personRepository;
    }

    public void execute() {
        Console.title("Add Contact Information");
        Console.inputOption("Person ID:");
        var id = keyboard.next();

        var person = personRepository.findById(id);

        if (person == null) {
            Console.line('-');
            Console.text("Person not found.");
            Console.line('-');
            return;
        }

        Console.inputOption("Contact Type (e.g., email, phone, address):");
        var type = keyboard.next();
        Console.inputOption("Contact Value:");
        var value = keyboard.next();

        var contact = new Contact(ContactType.fromString(value) ,value);
        person.addContact(contact);

        personRepository.update(person);
    }
}
