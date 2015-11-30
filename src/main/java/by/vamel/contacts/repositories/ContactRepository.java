package by.vamel.contacts.repositories;

import by.vamel.contacts.entities.Contact;


@org.springframework.stereotype.Repository
public class ContactRepository extends Repository<Contact> {

    public ContactRepository() {
        super(Contact.class);
    }
}
