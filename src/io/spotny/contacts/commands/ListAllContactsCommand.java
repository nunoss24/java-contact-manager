package io.spotny.contacts.commands;

import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.dal.Repository;

public class ListAllContactsCommand {
    
    private final Repository<Person> personRepository;

    public ListAllContactsCommand(Repository<Person> personRepository) {
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
