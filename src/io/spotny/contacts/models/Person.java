package io.spotny.contacts.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person implements Serializable{

    private String id;
    private String name;
    private List<Contact> contacts;

    public Person( String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return contacts
                .stream()
                .filter(contact -> contact.getType() == ContactType.EMAIL)
                .findFirst()
                .orElse(null)
                .getValue();
    }
    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public String toString() {
        return String.format("(%s) %s - %d contacts", id, name, contacts.size());
    }
}
