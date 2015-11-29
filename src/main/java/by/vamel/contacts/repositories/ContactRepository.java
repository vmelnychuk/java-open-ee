package by.vamel.contacts.repositories;

import by.vamel.contacts.entities.Address;
import by.vamel.contacts.entities.Contact;


import java.util.List;

public class ContactRepository extends Repository<Contact> {

    public ContactRepository() {
        super(Contact.class);
    }
}
