package io.spotny.contacts.app;

import java.util.List;
import java.util.Scanner;

import io.spotny.contacts.commands.AddNewContactCommand;
import io.spotny.contacts.commands.DeleteContactCommand;
import io.spotny.contacts.commands.ExportCSVCommand;
import io.spotny.contacts.commands.ListAllContactsCommand;
import io.spotny.contacts.commands.SearchContactCommand;
import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.dal.Repository;
import io.spotny.contacts.repositories.InMemoryPersonsRepositories;
import io.spotny.contacts.services.CSVExporterService;

public class ContactManager {

    private final Scanner keyboard;
    private boolean isRunning = false;

    private final Repository<Person> personRepository;
    private final CSVExporterService csvExporterService;

    private final AddNewContactCommand addNewContactCommand;
    private final ListAllContactsCommand listAllContactsCommand;
    private final SearchContactCommand searchContactCommand;
    private final DeleteContactCommand deleteContactCommand;
    private final ExportCSVCommand exportCSVCommand;

    public ContactManager() {
        keyboard = new Scanner(System.in);
        personRepository = new InMemoryPersonsRepositories();

        addNewContactCommand = new AddNewContactCommand(keyboard, personRepository);
        listAllContactsCommand = new ListAllContactsCommand(personRepository);
        searchContactCommand = new SearchContactCommand(keyboard, personRepository);
        deleteContactCommand = new DeleteContactCommand(keyboard, personRepository);
        exportCSVCommand = new ExportCSVCommand(keyboard, personRepository); 
    }

    public void start() {
        Console.clear();
        Console.showIntroduction();
        isRunning = true;
        while (isRunning) {
            Console.showTutorial();
            Console.inputOption("Option: ");
            var option = keyboard.nextInt();
            switch (option) {
                case 1 -> addNewContactCommand.execute();
                case 2 -> listAllContactsCommand.execute();
                case 3 -> searchContactCommand.execute();
                case 4 -> deleteContactCommand.execute();
                case 5 -> exportCSVCommand.execute();
                case 6 -> stop();
                default -> Console.invalidCommand();
            }

        }

        //Console.text("Press Enter to continue...");
        //keyboard.nextLine();
    }

    public void stop() {
        isRunning = false;
        Console.showTurnOff();
    }
}
