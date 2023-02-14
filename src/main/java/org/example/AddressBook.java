package org.example;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getNome().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByPhone(String phone) {
        for (Contact contact : contacts) {
            if (contact.getTelefono().equals(phone)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}
