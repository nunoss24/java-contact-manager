package io.spotny.contacts.models;

import java.io.Serializable;

public class Contact implements Serializable{
    
    private ContactType type;
    private String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Contact(String value) {
        this(ContactType.EMAIL, value);
    }

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
