package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Contact;
import io.spotny.contacts.models.ContactType;
import io.spotny.contacts.models.Person;
import io.spotny.contacts.repositories.PersonRepository;

public class AddNewContactCommand implements Command{

    private final Scanner keyboard;
    private final PersonRepository personRepository;

    public AddNewContactCommand(Scanner keyboard, PersonRepository personRepository) {
        this.keyboard = keyboard;
        this.personRepository = personRepository;
    }

    public void execute() {
        Console.title("Add New Contact");
        Console.inputOption("Name:");
        var name = keyboard.next();

        Console.inputOption("Contact:");
        var email = keyboard.next();

        var person = new Person(name);
        var contact = new Contact(email);
        person.addContact(contact);

        while (true) {
            Console.inputOption("Add another contact? (y/n):");
            var addAnother = keyboard.next();

            if (addAnother.equalsIgnoreCase("n")) {
                break;
            }

            var newContact = addContactToPerson(person);
            person.addContact(newContact);
        }

        personRepository.insert(person);
    }

    private Contact addContactToPerson(Person person) {
        Console.inputOption("Contact type (e.g., emial, phone, address):");
        var type = keyboard.next();
        Console.inputOption("Contact value:");
        var value = keyboard.next();

        var contact = new Contact(ContactType.fromString(type), value);
        person.addContact(contact);

        return contact;
    }
}
