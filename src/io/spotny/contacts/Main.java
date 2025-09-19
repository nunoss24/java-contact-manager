package io.spotny.contacts;

import io.spotny.contacts.app.ContactManager;

public class Main {
    public static void main(String[] args) {
        var app = new ContactManager();
        app.start();
    }
}
