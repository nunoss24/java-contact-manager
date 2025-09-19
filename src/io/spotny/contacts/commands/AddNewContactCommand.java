package io.spotny.contacts.commands;

import java.util.Scanner;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Contact;
import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.dal.Repository;

public class AddNewContactCommand {
    
    private final Scanner keyboard;
    private final Repository<Person> personRepository;


    public AddNewContactCommand(Scanner keyboard, Repository<Person> personRepository) {
        this.keyboard = keyboard;
        this.personRepository = personRepository;
    } 

    public void execute(){
        Console.title("Add New Contact");
        Console.inputOption("Name:");
        var name = keyboard.next();

        Console.inputOption("Contact:");
        var email = keyboard.next();

        var person = new Person(name);
        var contact = new Contact(email);

        person.addContact(contact);

        personRepository.insert(person);


    }
}
