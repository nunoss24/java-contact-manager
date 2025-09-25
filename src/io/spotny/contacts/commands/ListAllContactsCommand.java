package io.spotny.contacts.commands;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.repositories.PersonRepository;

public class ListAllContactsCommand implements Command {
    
    private final PersonRepository personRepository;

    public ListAllContactsCommand(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void execute(){
        Console.title("List All Contacts");
        var persons = personRepository.findAll();
        if (persons.isEmpty()) {
            Console.line('-');
            Console.text("No contacts found.");
            Console.line('-');
            return;
        }

        Console.list(persons);
    }
}
