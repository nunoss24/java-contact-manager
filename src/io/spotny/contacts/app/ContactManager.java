package io.spotny.contacts.app;

import java.util.List;
import java.util.Scanner;

import io.spotny.contacts.commands.AddContactInfoCommand;
import io.spotny.contacts.commands.AddNewContactCommand;
import io.spotny.contacts.commands.Command;
import io.spotny.contacts.commands.DeleteContactCommand;
import io.spotny.contacts.commands.ExportCSVCommand;
import io.spotny.contacts.commands.ListAllContactsCommand;
import io.spotny.contacts.commands.SearchContactCommand;
import io.spotny.contacts.io.Console;
import io.spotny.contacts.models.Person;
import io.spotny.contacts.persistence.Repository;
import io.spotny.contacts.repositories.FilesystemPersonsRepository;
import io.spotny.contacts.repositories.PersonRepository;
import io.spotny.contacts.services.CSVExporterService;
import io.spotny.contacts.services.Exportable;
import io.spotny.contacts.services.JsonExporterService;

public class ContactManager {

    private final Scanner keyboard;
    private boolean isRunning = false;

    private final PersonRepository personRepository;
    private final Exportable csvExporterService;

    private final Command addNewContactCommand;
    private final Command listAllContactsCommand;
    private final Command searchContactCommand;
    private final Command deleteContactCommand;
    private final Command exportCSVCommand;
    private final Command addContactInfoCommand;

    public ContactManager() {
        keyboard = new Scanner(System.in);
        //personRepository = new InMemoryPersonsRepositories();
        personRepository = new FilesystemPersonsRepository();
        csvExporterService = new JsonExporterService();

        addNewContactCommand = new AddNewContactCommand(keyboard, personRepository);
        listAllContactsCommand = new ListAllContactsCommand(personRepository);
        searchContactCommand = new SearchContactCommand(keyboard, personRepository);
        deleteContactCommand = new DeleteContactCommand(keyboard, personRepository);
        exportCSVCommand = new ExportCSVCommand(keyboard, personRepository, csvExporterService);
        addContactInfoCommand = new AddContactInfoCommand(keyboard, personRepository);
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
                case 5 -> addContactInfoCommand.execute();
                case 6 -> exportCSVCommand.execute();
                case 7 -> stop();
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
